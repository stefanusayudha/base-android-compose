### Why Koin not Hilt
Ini lebih ke preferensi. Saya kurang suka hilt karena dia meng interfensi objek yang akan di inject dan memberi sedikit pattern lebih pada objek yang menggunakan fitur ini. Yes, saya kurang suka menggunakan anotasi ketika melakukan injeksi. Salah satu contohnya pattern ini memaksa kita menggunakan late init, artinya proyek tidak hanya depend ke Hilt tapi pattern dari proyek juga akan tightly coupled ke Hilt itu sendiri.

Contoh:
```
@Provides
fun provideMusicDB(@ApplicationContext context: Context): MusicDatabase {
  return Room.databaseBuilder (
      context, 
      MusicDatabase::class.java, "music.db" 
  ).build()
}
```

Bagi saya it is like yikes. Sorry to say.

Menurut saya contoh di atas tidak lagi bisa di sebut sebagai pure function.

Contoh lain, dengan Hilt anda perlu melakukan ini:
```
@Inject late init var module: Module
```

Sementara dengan koin cukup seperti ini:
```
private val module: Module = get()
```
Bagi saya adalah pendekatan yang jauh lebih baik.

### Build Flavor
Jika anda ingin mencoba build flavor staging dan release, anda perlu membuat sebuah keystore / key signature.
Langkah petunjuk dapat anda lihat pada: [keystore.properties.example](keystore.properties.example)

### Slow Build
Proyek ini menggunakan precompile script sehingga anda mungkin akan merasakan build time yang sedikit lebih lama.
