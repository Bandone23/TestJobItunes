package com.example.mytestitunesnew.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core.coroutines.Result
import com.example.core.extension.observe

import com.example.mytestitunesnew.R
import com.example.mytestitunesnew.databinding.FragmentSongBinding
import com.example.mytestitunesnew.domain.model.SongList
import com.example.mytestitunesnew.presentation.viewmodel.SongViewModel
import com.example.mytestitunesnew.ui.activity.BaseFragment
import kotlinx.android.synthetic.main.fragment_song.*
import org.jetbrains.anko.support.v4.longToast
import org.koin.androidx.viewmodel.ext.android.viewModel


class SongFragment : BaseFragment() {
    companion object {
        fun newInstance() = SongFragment()
    }


    private val viewModel: SongViewModel by viewModel()
    lateinit var binding: FragmentSongBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel.initAdapter { song: SongList, viewId: Int -> songClicked(song, viewId) }
        binding = FragmentSongBinding.inflate(inflater, container, false)
        binding.lifecycleOwner =this
        binding.viewModel =viewModel
        val layoutManger = (LinearLayoutManager(activity, RecyclerView.VERTICAL, false))
        binding.recyclersong.layoutManager = layoutManger

        with(viewModel) {
            observe(songLiveData, ::songObserver)

        }
        viewModel.getSong()


        return binding.root
    }

    private fun songObserver(result: Result<List<SongList>>?) {
        when (result) {
            is Result.OnLoading -> {
                binding.progressCircular.visibility =View.VISIBLE
            }
            is Result.OnSuccess -> {
                if (result.value.isNotEmpty()) {
                    binding.progressCircular.visibility =View.GONE

                    viewModel.updateSong(result.value)
                    longToast("datos cargados correctamente ")
                } else {
                    longToast("la lista esta vacia")
                }

            }
            is Result.OnError -> {
            }
            is Result.OnCancel -> {
            }
            else -> {
            }
        }
    }


    private fun songClicked(song: SongList, viewId: Int) {
        when (viewId) {
            R.id.imageView -> {
               /* val auditMatchFragment =
                    AuditMatchFragment.newInstance(matches.time_match, matches.date)
                auditMatchFragment.show(fragmentManager!!, "audit match")*/


            }

        }
    }


}
