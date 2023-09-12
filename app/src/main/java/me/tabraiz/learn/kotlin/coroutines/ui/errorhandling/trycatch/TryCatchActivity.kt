package me.tabraiz.learn.kotlin.coroutines.ui.errorhandling.trycatch

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*
import me.tabraiz.learn.kotlin.coroutines.R
import me.tabraiz.learn.kotlin.coroutines.data.api.ApiHelperImpl
import me.tabraiz.learn.kotlin.coroutines.data.api.RetrofitBuilder
import me.tabraiz.learn.kotlin.coroutines.data.local.DatabaseBuilder
import me.tabraiz.learn.kotlin.coroutines.data.local.DatabaseHelperImpl
import me.tabraiz.learn.kotlin.coroutines.data.model.ApiUser
import me.tabraiz.learn.kotlin.coroutines.ui.base.ApiUserAdapter
import me.tabraiz.learn.kotlin.coroutines.ui.base.UiState
import me.tabraiz.learn.kotlin.coroutines.ui.base.ViewModelFactory

class TryCatchActivity : AppCompatActivity() {

    private lateinit var viewModel: TryCatchViewModel
    private lateinit var adapter: ApiUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter =
            ApiUserAdapter(
                arrayListOf()
            )
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        viewModel.getUiState().observe(this) {
            when (it) {
                is UiState.Success -> {
                    progressBar.visibility = View.GONE
                    renderList(it.data)
                    recyclerView.visibility = View.VISIBLE
                }
                is UiState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                is UiState.Error -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun renderList(users: List<ApiUser>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                ApiHelperImpl(RetrofitBuilder.apiService),
                DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
            )
        )[TryCatchViewModel::class.java]
    }

}
