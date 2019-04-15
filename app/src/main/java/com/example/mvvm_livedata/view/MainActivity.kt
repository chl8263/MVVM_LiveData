package com.example.mvvm_livedata.view

import android.content.Intent
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_livedata.R
import com.example.mvvm_livedata.adapter.MainRecyclerViewAdapter
import com.example.mvvm_livedata.core.BaseActivity
import com.example.mvvm_livedata.viewmodel.MainViewModel
import com.example.mvvm_livedata.databinding.ActivityMainBinding
import com.example.mvvm_livedata.model.dto.RepoDTO
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {


    override val layoutResourceId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel by inject()

    private val mainRecyclerViewAdapter : MainRecyclerViewAdapter by inject()


    override fun initStartView() {
        recyclerView.run {
            adapter = mainRecyclerViewAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun initDataBinding() {
        viewModel.githubLiveData.observe(this , Observer {
            mainRecyclerViewAdapter.list = it as ArrayList<RepoDTO>
            mainRecyclerViewAdapter.notifyDataSetChanged()
        })

        viewModel.startSubActivityEvent.observe(this , Observer {
            startActivity(Intent(this, SubActivity::class.java))
        })

        //viewModel.getGithubData("chl8263")
        /*val service : GithubService = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.github.com")
            .build()
            .create(GithubService::class.java)*/

        /*service.listRepos("chl8263")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e("aa", it.toString())
            },{
                Log.e("aa", "ㅜㅜ")
            })*/
    }

    override fun initAfterBinding() {
        button.setOnClickListener {
            viewModel.getGithubData(editText.text.toString())
        }
        goSub.setOnClickListener {
            viewModel.goSubActivity()
        }
    }
}
