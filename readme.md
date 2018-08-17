# APLIKASI MODUL AKADEMIK

Ini merupakan aplikasi modul akademik yang merupakan bagian dari sistem aplikasi SIAK-FG. Aplikasi ini dikembangkan oleh kelompok C11 mata kuliah APAP 2017. Kelompok C11 terdiri atas:
* Luthfi Abdurrahim
* Galuh Octavia
* Farhan Achsani
* Farhan Ramadhan

## Getting Started

Berikut ini merupakan penjelasan ringkas serta dokumentasi API dari proyek aplikasi modul akademik yang dikembangkan oleh C11. Instruksi ini berisi mengenai bagaimana cara menjalankannya di local machine Anda untuk tujuan development.

### Prerequisites

What things you need to install the software and how to install them

```
Java 1.8
Spring Boot
Maven
Mysql
```

## Built With

* [Thymeleaf](http://www.dropwizard.io/1.0.2/docs/) - The front end engine framework used
* [Bootstrap](http://www.dropwizard.io/1.0.2/docs/) - The css framework
* [Maven](https://maven.apache.org/) - Dependency Management
* [Springboot Java](https://rometools.github.io/rome/) - Framework Java

## Contributing

Just clone and contact us for further development.


## Authors

* **Luthfi Abdurrahim** - *Web Developer* - [luthviar](https://github.com/luthviar)
* **Galuh Octavia** - *Web Developer* - [galuhoctavia](https://github.com/galuhoctavia)
* **Farhan Achsani** - *Web Developer* - [Achsani](https://github.com/Achsani)
* **Farhan Ramadhan** - *Web Developer* - [farhanraa](https://github.com/farhanraa)

See also the list of [contributors](https://github.com/apap-2017/ta_c11/contributors) who participated in this project.

## License

This project is licensed under the MIT License.

## API Documentation

### Aplikasi Modul Akademik

Base url: `https://localhost:4040/api/akademik`

API List:
* [/getMahasiswa](#/getMahasiswa)
* [/getStatusLulus](#/getStatusLulus)
* [404 Error](#404-error)

## /getMahasiswa

Mengembalikan data seluruh Mahasiswa.

**URL** : `/getMahasiswa`

**Method** : `GET`

### Success Response

**Contoh Request**: [/getMahasiswa](#)

```json
{
	"status": 200,
	"msg": "success",
	"result": {
		"mahasiswa": [
			{
				"npm": "1506123456",
				"username": "gugun.dah",
				"nama_lengkap": "Gugun Hidayat",
				"IPK": "0",
				"id_fakultas": "1",
				"id_prodi": "1",
				"id_univ": "1",
				"jenjang": "S1",
				"kode_kurikulum": "CSUI2015",
				"tahun_masuk": "2015"
			},
			{
				"npm": "1506123452",
				"username": "gugun.dah2",
				"nama_lengkap": "Gugun Hidayat2",
				"IPK": "0",
				"id_fakultas": "1",
				"id_prodi": "1",
				"id_univ": "1",
				"jenjang": "S1",
				"kode_kurikulum": "CSUI2012",
				"tahun_masuk": "2012"
			}
		]
	}
}
```

## /getStatusLulus

Mengembalikan status lulus dari seluruh Mahasiswa.

**URL** : `/getStatusLulus

**Method** : `GET`

### Success Response
**Contoh Request**: [/getStatusLulus](#)

```json
{
	"status": 200,
	"msg": "success",
	"result": {
		"status_lulus": [
			{
				"npm": "1506123456",
				"username": "gugun.dah",
				"nama_lengkap": "Gugun Hidayat",
				"status_lulus": "lulus",
                "is_wisuda": "false",
                "is_aktif" : "false"
			},
			{
				"npm": "1506123452",
				"username": "gugun.dah2",
				"nama_lengkap": "Gugun Hidayat2",
				"status_lulus": "lulus",
                "is_wisuda": "false",
                "is_aktif" : "false"
			},
			{
				"npm": "1506123453",
				"username": "gugun.dah3",
				"nama_lengkap": "Gugun Hidayat3",
				"status_lulus": "lulus",
                "is_wisuda": "false",
                "is_aktif" : "false"
			},
			{
				"npm": "1506123454",
				"username": "gugun.dah4",
				"nama_lengkap": "Gugun Hidayat4",
				"status_lulus": "lulus",
                "is_wisuda": "false",
                "is_aktif" : "false"
			}
		]
	}
}
```

## 404 Error

**Condition** : Jika pengguna mengakses URL yang tidak ada dalam Aplikasi Akademik

**Contoh Request**: [/](#)
```json
{"status":404,"msg":"404 URL tidak ditemukan"}
```

**Contoh Request**: [/getStatusLulusssss](#)
```json
{"status":404,"msg":"404 URL tidak ditemukan"}
```
