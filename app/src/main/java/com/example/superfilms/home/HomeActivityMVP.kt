package com.example.superfilms.home

interface HomeActivityMVP {

    interface View {
    }

    interface Presenter {
        fun setView(view: HomeActivity)
        fun favoriteButton()
        fun detailButton()
    }

    interface  Model {
        fun getAllFilms()
    }

}