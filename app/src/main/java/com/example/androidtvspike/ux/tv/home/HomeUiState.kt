package com.example.androidtvspike.ux.tv.home

data class HomeUiState(
    val banners: List<Banner> = Banner.getDefaultBanners(),
    val players: List<Player> = Player.getDefaultPlayers(),
    val countries: List<Country> = Country.getDefaultCountries(),
)

data class Banner(
    val id: Int,
    val name: String,
    val title: String,
    val imageUrl: String,
) {
    companion object {
        fun getDefaultBanners(): List<Banner> = listOf(
            Banner(
                id = 1,
                name = "Brazil",
                title = "5 world cups",
                imageUrl = "https://cloudinary.fifa.com/m/1235c8e740e132da/webimage-Brazil-team-celebrates.png"
            ),
            Banner(
                id = 2,
                name = "France",
                title = "2 world cups",
                imageUrl = "https://www.aljazeera.com/wp-content/uploads/2018/07/4bf443ed2dd4448d8c73e4ceacd4464b_18.jpeg"
            ),
            Banner(
                id = 4,
                name = "Argentina",
                title = "2 world cups",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/1/18/Argentina_celebrando_copa.jpg"
            ),
            Banner(
                id = 3,
                name = "Spain",
                title = "1 world cup",
                imageUrl = "https://assets.goal.com/v3/assets/bltcc7a7ffd2fbf71f5/blt68cae87b88d7ecc3/62728d82c41f845ae3b6d256/GettyImages-146385808_(1).jpg?quality=80&format=pjpg&auto=webp&width=1000"
            ),
        )
    }
}

data class Player(
    val id: Int,
    val name: String,
    val imageUrl: String,
) {
    companion object {
        fun getDefaultPlayers(): List<Player> = listOf(
            Player(
                id = 1,
                name = "Cristiano Ronaldo",
                imageUrl = "https://digitalhub.fifa.com/transform/9d9740e9-c656-456d-b402-2ea49cfdf38a/Faro-Portugal-1-September-2021-Cristiano-Ronaldo-of-Portugal-celebrates-following-the-FIFA-World-Cup-2022-qualifying-group-A-match-between-Portugal-and-Republic-of-Ireland-at-Estadio-Algarve-in-Faro-Portugal-Photo-By-Stephen-McCarthy-Sportsfile-via-Getty-Images"
            ),
            Player(
                id = 2,
                name = "Lionel Messi",
                imageUrl = "https://cloudfront-us-east-1.images.arcpublishing.com/infobae/BVKQXXXAH5BPTMDI6CZOWETVVU.jpg"
            ),
            Player(
                id = 3,
                name = "Kylian Mbappé",
                imageUrl = "https://phantom-marca.unidadeditorial.es/1ed7d63f9e88f5fd121eef7764eb8af8/resize/1320/f/jpg/assets/multimedia/imagenes/2022/09/22/16638791534283.jpg"
            ),
            Player(
                id = 4,
                name = "Neymar Jr",
                imageUrl = "https://media.cnn.com/api/v1/images/stellar/prod/220930165943-01-neymar.jpg?c=original"
            ),
            Player(
                id = 5,
                name = "Gavi",
                imageUrl = "https://images.daznservices.com/di/library/DAZN_News/9d/e2/gavi-espana-mundial-2022_gf5w1f5j8yjd19zfcecoly2mh.jpg?t=-1441082012&quality=60&w=1280&h=720"
            ),
        )
    }
}

data class Country(
    val id: Int,
    val name: String,
    val imageUrl: String,
) {
    companion object {
        fun getDefaultCountries(): List<Country> = listOf(
            Country(
                id = 1,
                name = "Brazil",
                imageUrl = "https://upload.wikimedia.org/wikipedia/en/thumb/0/05/Flag_of_Brazil.svg/1200px-Flag_of_Brazil.svg.png"
            ),
            Country(
                id = 2,
                name = "France",
                imageUrl = "https://cdn.britannica.com/82/682-004-F0B47FCB/Flag-France.jpg"
            ),
            Country(
                id = 3,
                name = "Portugal",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Flag_of_Portugal.svg/255px-Flag_of_Portugal.svg.png"
            ),
            Country(
                4,
                "USA",
                "https://upload.wikimedia.org/wikipedia/en/thumb/a/a4/Flag_of_the_United_States.svg/1200px-Flag_of_the_United_States.svg.png"
            ),
            Country(
                id = 5,
                name = "Uruguay",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/f/fe/Flag_of_Uruguay.svg"
            ),
            Country(
                id = 6,
                name = "Poland",
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/Flag_of_Poland.svg/2560px-Flag_of_Poland.svg.png"
            ),
        )
    }
}
