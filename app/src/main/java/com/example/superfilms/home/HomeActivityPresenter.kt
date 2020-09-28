package com.example.superfilms.home

import android.util.Log
import androidx.annotation.Nullable


class HomeActivityPresenter(
    @Nullable
    model: HomeActivityMVP.Model
) : HomeActivityMVP.Presenter {
    @Nullable
    private lateinit var view: HomeActivityMVP.View

    override fun setView(view: HomeActivity) {
        this.view = view
    }

    override fun favoriteButton() {}

    override fun detailButton() {}
}