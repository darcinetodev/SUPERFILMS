package com.example.superfilms.home

import android.os.Bundle
import android.widget.Button
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Optional
import com.example.superfilms.R
import com.example.superfilms.adapter.FilmsAdapter
import com.example.superfilms.model.Film
import com.example.superfilms.repository.FilmApi
import com.example.superfilms.root.App
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class HomeActivity: AppCompatActivity(), HomeActivityMVP.View {

    @Inject
    lateinit var presenter: HomeActivityMVP.Presenter

    @Inject
    lateinit var filmApi: FilmApi

    @Nullable
    @BindView(R.id.favorite_btn)
    lateinit var favoriteBtn: Button

    @Nullable
    @BindView(R.id.details_btn)
    lateinit var detailsBtn: Button

    @Nullable
    @BindView(R.id.recycler_films)
    lateinit var recyclerFilms: RecyclerView

    @Optional
    @OnClick(R.id.favorite_btn)
    fun onClickFavorite() {
        presenter.favoriteButton()
    }

    @Optional
    @OnClick(R.id.details_btn)
    fun onClickDetail() {
        presenter.detailButton()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this);

        App().getComponent().inject(this)

        val layoutManager = LinearLayoutManager(this)
        recyclerFilms.layoutManager = layoutManager

        val call = filmApi.getAllFilms("752dafb6a104c773d506853a69082837")

        call.enqueue(object : Callback<Film?> {
            override fun onResponse(call: Call<Film?>, response: Response<Film?>) {
                recyclerFilms.adapter = FilmsAdapter(response.body()?.results)
            }

            override fun onFailure(call: Call<Film?>, t: Throwable?) {}
        })
    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
    }
}