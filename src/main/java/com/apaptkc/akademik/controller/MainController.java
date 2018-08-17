package com.apaptkc.akademik.controller;

import com.apaptkc.akademik.dao.IrsRepository;
import com.apaptkc.akademik.dao.KurikulumDAO;
import com.apaptkc.akademik.dao.SekretariatDAO;
import com.apaptkc.akademik.dao.UniversitasDAO;
import com.apaptkc.akademik.model.*;
import com.apaptkc.akademik.service.*;
import com.apaptkc.akademik.spec.*;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    IrsService irsService;

    @Autowired
    MahasiswaService mhsService;

    @Autowired
    AkunService akunService;

    @Autowired
    RiwayatService riwayatService;

    @Autowired
    StatusLulusService statusLulusService;

    @Autowired
    UniversitasDAO univDAO;

    @Autowired
    KurikulumDAO kurikulumDAO;

    @Autowired
    UniversitasDAO univAPI;

    @Autowired
    SekretariatDAO sekreAPI;

    @Autowired
    PenilaianMatkulService penilaianService;

    @RequestMapping("/")
    public String index() {
        if ( SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().equals("[USER]") ||  SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().equals("[ROLE_USER]")) {
            return "redirect:mahasiswa";

        } else if (SecurityContextHolder.getContext().getAuthentication() != null &&  SecurityContextHolder.getContext().getAuthentication().isAuthenticated() && !(SecurityContextHolder.getContext().getAuthentication()
                instanceof AnonymousAuthenticationToken) ){
            return "redirect:dashboard";
        } else {
        	return "index";
        }
    }

    @RequestMapping("/home")
    public String home() {
        return "index";
    }

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard-admin";
    }

    @RequestMapping("/mahasiswa")
    public String dashboardMhs() {
        return "dashboard-mahasiswa";
    }

    @RequestMapping("/admin")
    public String dashboardAdmin(){return "dashboard-admin";}

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/portal")
    public String portal(){
        return "portal";
    }

    @RequestMapping("/mahasiswa/irs/add")
    public String addIrs(IrsEntity irs, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        MahasiswaEntity mahasiswa = mhsService.getMahasiswaByUsername(username);
        List<SekretariatSpec> allKelas = sekreAPI.getAllKelasByKurikulumAndTerm(mahasiswa.getKodeKurikulum(), "2014/2015-2");
        KurikulumSpec kurikulum = kurikulumDAO.getKurikulum(mahasiswa.getKodeKurikulum());
        HashMap<String, MataKuliahSpec> listIdMatkul = new HashMap<String, MataKuliahSpec>();
        ArrayList<MataKuliahSpec> listMatkul = new ArrayList<MataKuliahSpec>();
        for(int i = 0; i < allKelas.size(); i++){
            listIdMatkul.put(allKelas.get(i).getId_matkul(), kurikulum.getMataKuliahById(allKelas.get(i).getId_matkul()));
            if (listIdMatkul.get(allKelas.get(i).getId_matkul()).getListKelas() == null)
            {
                listIdMatkul.get(allKelas.get(i).getId_matkul()).createKelas();
            }
            listIdMatkul.get(allKelas.get(i).getId_matkul()).getListKelas().add(allKelas.get(i));
        }
        for(String key : listIdMatkul.keySet()){
            listMatkul.add(listIdMatkul.get(key));
        }

        List<String> result = new ArrayList<String>();
        model.addAttribute("result", result);
        model.addAttribute("listMatkul", listMatkul);
        model.addAttribute("allKelas", allKelas);
    	model.addAttribute("irs", irs);
        return "add-irs-mahasiswa";
    }

    @RequestMapping(value = "/mahasiswa/irs/add/submit", method = RequestMethod.POST)
    public String addIrsSubmit(Model model, @RequestParam("result") List<String> result){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        if (result.isEmpty()){
            return "add-irs-mahasiswa";
        }

        MahasiswaEntity mhs = mhsService.getMahasiswaByUsername(username);

        List<String> addedKodeMK = new ArrayList<String>();
        List<String> addedKelas = new ArrayList<String>();
        List<String> dumped = new ArrayList<String>();

        for (int i = 0; i<result.size(); i++){
            String curr = result.get(i);
            String[] splitResult = curr.split("-");
            String kodeMK = splitResult[0];
            String idKelas = splitResult[1];
            if(addedKodeMK.contains(kodeMK)){
                dumped.add(curr);
            }else{
                addedKodeMK.add(kodeMK);
                addedKelas.add(idKelas);
                AddIrsSpec temp = new AddIrsSpec(mhs, kodeMK, idKelas);
                irsService.addIrs(temp);
            }
        }
        model.addAttribute("addedKodeMK", addedKodeMK);
        model.addAttribute("addedKelas", addedKelas);
        model.addAttribute("dumped", dumped);
        return "sukses-add-irs";
    }

    @RequestMapping("/mahsiswa/getIrs/{id}")
    public String getIrs(Model model, @PathVariable(value = "id")int id){
        IrsEntity irs = irsService.getIrs(id);
        model.addAttribute("irs", irs);
        model.addAttribute("page", "view-irs");
        System.out.print("masuk");
        System.out.print(irs.getId());
        return "view";
    }

    @RequestMapping("/mahasiwa/getIrs/term/{term}")
    public String getIrsByTerm(Model model, @PathVariable(value = "term")String term){
        List<IrsEntity> listIrs = irsService.getIrsByTerm(term);
        model.addAttribute("listIrs", listIrs);
        return "view";
    }

    @RequestMapping("/mahasiwa/getAllIrs/{id}")
    public String getIrsByTerm(Model model, @PathVariable(value = "id")int id){
        List<IrsEntity> listIrs = irsService.getIrsByIdMahasiswa(id);
        model.addAttribute("listIrs", listIrs);
        return "view-irs-by-mhs";
    }

    @RequestMapping("/admin/addMhs")
    public String addMahasiswa(Model model){
        List<KurikulumSpec> allKurikulum = kurikulumDAO.getAllKurikulum();
        AddMahasiswaSpec mhsSpec = new AddMahasiswaSpec();
        model.addAttribute("mhsSpec",mhsSpec);
        model.addAttribute("allKurikulum", allKurikulum);
        return "form_add_mahasiswa";
    }

    @RequestMapping(value = "/admin/addMhs", method = RequestMethod.POST)
    public String addMahasiswaSubmit(Model model,
                                     @ModelAttribute AddMahasiswaSpec mhsSpec){
        KurikulumSpec kurikulumSpec = kurikulumDAO.getKurikulum(mhsSpec.getKodeKurikulum());
        int id_univ = Integer.parseInt(kurikulumSpec.getId_universitas());
        int id_fakultas = Integer.parseInt(kurikulumSpec.getId_fakultas());
        int id_prodi = Integer.parseInt(kurikulumSpec.getId_prodi());

        mhsService.addMahasiswa(mhsSpec, id_univ, id_fakultas, id_prodi);
        model.addAttribute("username", mhsSpec.username);
        model.addAttribute("npm", mhsSpec.npm);
        return "success_add_mahasiswa";
    }

    @RequestMapping("/admin/updateStatusMhs/{npm}")
    public String updateStatusMahasiswa(Model model, @PathVariable("npm") String npm){
        StatusLulusEntity statusLulus = statusLulusService.getStatusLulusByNpm(npm);
        UpdateStatusSpec updateStatusSpec = new UpdateStatusSpec(statusLulus);
        model.addAttribute(updateStatusSpec);
        return "form_updateStatusMhs";
    }

    @RequestMapping(value = "/admin/updateStatusMhs", method = RequestMethod.POST)
    public String updateStatusMahasiswaSubmit(Model model,
                                        @ModelAttribute UpdateStatusSpec updateStatusSpec){
        statusLulusService.updateStatusLulus(updateStatusSpec);
        model.addAttribute("username", updateStatusSpec.getUsername());
        model.addAttribute("npm", updateStatusSpec.getNpm());
        return "sukses_update_kelulusan";
    }

    @RequestMapping("/mahasiswa/riwayat/lihat")
    public String viewRiwayat(Model model){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        if (username != null){
            MahasiswaEntity mahasiswa = mhsService.getMahasiswaByUsername(username);
            model.addAttribute("mahasiswa", mahasiswa);
            List<RiwayatEntity> allRiwayat = riwayatService.getRiwayatByUsername(username);
            model.addAttribute("allRiwayat", allRiwayat);

            //count ipk
            double ipk =0;
            int totalSKSLulus = 0;

            for (int i = 0; i < allRiwayat.size(); i++) {
                ipk += allRiwayat.get(i).getIp();
                totalSKSLulus += allRiwayat.get(i).getSksLulus();
            }
            ipk = ipk/allRiwayat.size();

            model.addAttribute("ipk",ipk);
            model.addAttribute("totalSKSLulus", totalSKSLulus);
            return "view-riwayat";

        }
        return "login";
    }

//    @RequestMapping("/mahasiswa/riwayat/lihat/detail1/{id_riwayat}")
//    public String viewDetailNilai1(Model model,  @PathVariable("id_riwayat") int id_riwayat){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String username = auth.getName();
//        if (username != null) {
//            MahasiswaEntity mahasiswa = mhsService.getMahasiswaByUsername(username);
//            model.addAttribute("mahasiswa", mahasiswa);
//            RiwayatEntity riwayat = riwayatService.getRiwayatById(id_riwayat);
//            model.addAttribute("riwayat", riwayat);
//            List<PenilaianMatkulEntity> allNilai = penilaianService.getPenilaianMatkulByRiwayat(id_riwayat);
//            model.addAttribute("allNilai", allNilai);
//            return "view-detail-nilai";
//        }
//        return "login";
//    }

    @RequestMapping("/mahasiswa/riwayat/lihat/detail/{id_riwayat}")
    public String viewDetailNilai(Model model,  @PathVariable("id_riwayat") int id_riwayat){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        MahasiswaEntity mahasiswa = mhsService.getMahasiswaByUsername(username);
        model.addAttribute("mahasiswa", mahasiswa);
        
        List<PenilaianMatkulEntity> allNilai = penilaianService.getPenilaianMatkulByRiwayat(id_riwayat);
        model.addAttribute("allNilai", allNilai);
        
        KurikulumSpec kurikulum = kurikulumDAO.getKurikulum(mahasiswa.getKodeKurikulum());
        
        HashMap<String ,MataKuliahSpec> listMatkul = new HashMap<String, MataKuliahSpec>();
        System.out.println("masuk");
        System.out.println(kurikulum.getMataKuliahByKodeMataKuliah(allNilai.get(0).getKodeMk()));
        for(int i = 0; i < allNilai.size(); i++){
            listMatkul.put(allNilai.get(i).getKodeMk(), kurikulum.getMataKuliahByKodeMataKuliah(allNilai.get(i).getKodeMk()));
        }
        model.addAttribute("listMatkul", listMatkul);
       
        
        
        RiwayatEntity riwayat = riwayatService.getRiwayatById(id_riwayat);
        model.addAttribute("riwayat", riwayat);
        
        return "view-detail-nilai";
    }


    @RequestMapping("/mahasiswa/status-kelulusan")
    public String viewStatusKelulusan(Model model){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        MahasiswaEntity mahasiswa = mhsService.getMahasiswaByUsername(username);
        
        //mengambil syarat banyaknya sks lulus
        SyaratLulusSpec syaratLulus = kurikulumDAO.getSyaratLulus(mahasiswa.getKodeKurikulum());
        int syaratSKSLulus = syaratLulus.getJumlah_sks();
        
        //menghitung banyak sks pada db per mahasiswa
        List<RiwayatEntity> allRiwayat = riwayatService.getRiwayatByUsername(username);
        model.addAttribute("allRiwayat", allRiwayat);
        
        int totalSKSLulus =0;

        for (int i = 0; i < allRiwayat.size(); i++) {
            totalSKSLulus += allRiwayat.get(i).getSksLulus();
		}
        
        //mengecek kelulusan
        boolean cekLulus = false;
        int cekSisa = 0;
        if(totalSKSLulus >= syaratSKSLulus) {
        	cekLulus = true;
        	cekSisa =  syaratSKSLulus - totalSKSLulus;
        	
        } else {
        	cekLulus = false;
        	cekSisa = syaratSKSLulus-totalSKSLulus;
        	System.out.println(cekSisa);
        }
    	StatusLulusEntity statusLulus = statusLulusService.getStatusLulusByUsername(username);
    	
    	model.addAttribute("syaratLulus",syaratLulus);
        model.addAttribute("statusLulus", statusLulus);
        model.addAttribute("mahasiswa", mahasiswa);
        model.addAttribute("cekLulus", cekLulus);
        model.addAttribute("cekSisa",cekSisa);
        return "view-status-kelulusan-mahasiswa";
    }

    @RequestMapping("/mahasiswa/irs/lihat")
    public String getIrsByUsername(Model model){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getName() != null){
    	    String username = auth.getName();
            MahasiswaEntity mahasiswa = mhsService.getMahasiswaByUsername(username);
            model.addAttribute("mahasiswa", mahasiswa);
            KurikulumSpec kurikulum = kurikulumDAO.getKurikulum(mahasiswa.getKodeKurikulum());
            List<IrsEntity> listIrs = irsService.getIrsByUsernameMahasiswa(username);
            HashMap<String ,MataKuliahSpec> listMatkul = new HashMap<String, MataKuliahSpec>();
            System.out.println("masuk");
            System.out.println(listMatkul.put(listIrs.get(0).getKodeMK(), kurikulum.getMataKuliahByKodeMataKuliah(listIrs.get(0).getKodeMK())));
            for(int i = 0; i < listIrs.size(); i++){
                listMatkul.put(listIrs.get(i).getKodeMK(), kurikulum.getMataKuliahByKodeMataKuliah(listIrs.get(i).getKodeMK()));
            }
            model.addAttribute("listMatkul", listMatkul);
            model.addAttribute("listIrs", listIrs);

            return "view-irs-by-mhs";
        }
        return "login";
    }


    @RequestMapping("/mahasiswa/profile/view")
    public String viewProfileMahasiwa(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.getName() != null){
            String name = auth.getName(); //get logged in username
            MahasiswaEntity mhs = mhsService.getMahasiswaByUsername(name);
            UniversitasSpec univ = univDAO.getUniversitas(mhs.getIdUniv());
            FakultasSpec fakultas = univDAO.getFakultas(mhs.getIdUniv(), mhs.getIdFakultas());
            ProdiSpec prodi = univDAO.getProdi(mhs.getIdUniv(), mhs.getIdFakultas(), mhs.getIdProdi());
            KurikulumSpec kurikulum = kurikulumDAO.getKurikulum(mhs.getKodeKurikulum());
            model.addAttribute( "univ", univ);
            model.addAttribute("fakultas", fakultas);
            model.addAttribute("prodi", prodi);
            model.addAttribute("kurikulum", kurikulum);
            model.addAttribute("mhs", mhs);
            return "view-profile-mahasiswa";     }
        return "login";
    }

    @RequestMapping("/admin/statuslulus/getAll")
    public String getAllStatusKelulusan(Model model){
        List<StatusLulusEntity> allStatusLulus = statusLulusService.getAll();
        model.addAttribute("allStatusLulus", allStatusLulus);
        return "view-status-kelulusan-admin";
    }

    @RequestMapping("/admin/kelola-mahasiswa")
    public String getKelolaMahasiswa(Model model){

    	 List<MahasiswaEntity> mhs = mhsService.getAllMahasiswa();
    	 model.addAttribute("mhs", mhs);
         return "kelola-mahasiswa";
    }

    @RequestMapping("/admin/edit-mahasiswa/{idMhs}")
    public String editMahasiswa(Model model, @PathVariable(value = "idMhs") int idMhs){
        List<KurikulumSpec> allKurikulum = kurikulumDAO.getAllKurikulum();

        MahasiswaEntity mhs = mhsService.getMahasiswa(idMhs);
        UpdateMahasiswaSpec updateMhsSpec = new UpdateMahasiswaSpec(mhs);

        model.addAttribute("allKurikulum", allKurikulum);
        model.addAttribute("updateMhsSpec", updateMhsSpec);
        return "form-edit-mahasiswa";
    }

    @RequestMapping(value = "admin/edit-mahasiswa/submit", method = RequestMethod.POST)
    public String editMahasiswaSubmit(Model model, @ModelAttribute UpdateMahasiswaSpec updateMhsSpec){
        mhsService.updateMahasiswa(updateMhsSpec);
        model.addAttribute("username", updateMhsSpec.getUsername());
        model.addAttribute("npm", updateMhsSpec.getNpm());
        return "sukses_update_mahasiswa";
    }

    @RequestMapping("/mahasiswa/irs/drop")
    public String dropIrs(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.getName() != null){
            String name = auth.getName(); //get logged in username
            model.addAttribute("name", name);
            MahasiswaEntity mhs = mhsService.getMahasiswaByUsername(name);
            List<IrsEntity> listIrs = irsService.getIrsByUsernameAndTerm(mhs.getUsername(),"2014/2015-2");
            model.addAttribute("listIrs",listIrs);

            KurikulumSpec kurikulum = kurikulumDAO.getKurikulum(mhs.getKodeKurikulum());
            HashMap<String ,MataKuliahSpec> listMatkul = new HashMap<String, MataKuliahSpec>();
            for(int i = 0; i < listIrs.size(); i++){
                listMatkul.put(listIrs.get(i).getKodeMK(), kurikulum.getMataKuliahByKodeMataKuliah(listIrs.get(i).getKodeMK()));
            }
            model.addAttribute("listMatkul", listMatkul);

            List<Integer> result = new ArrayList<Integer>();
            model.addAttribute("result", result);

            return "drop-irs-mahasiswa";
        }
        return "login";
    }

    @RequestMapping(value = "/mahasiswa/irs/drop/submit", method = RequestMethod.POST)
    public String dropIrsSubmit (Model model, @RequestParam(value = "result", required = false) List<String> result){
        //iterating to drop all irs that on the list
        ArrayList<String> dropped = new ArrayList<String>();
        for (int i = 0; i<result.size(); i++){
            String[] split = result.get(i).split("-");
            int id = Integer.parseInt(split[0]);
            String nama_matkul = split[1];
            //drop irs with id
            irsService.deleteIrsById(id);
            dropped.add(nama_matkul);
        }
        model.addAttribute("dropped", dropped);
        return "sukses-drop-irs";
    }

}
