package com.example.mytestitunesnew.domain.usecase

import com.example.core.coroutines.ResultUnitUseCase
import com.example.mytestitunesnew.data.repository.SongRepository
import com.example.mytestitunesnew.domain.model.SongList
import kotlinx.coroutines.Dispatchers

class GetSongUseCase (
    private val repository: SongRepository
): ResultUnitUseCase<List<SongList>>(
    backgroundContext = Dispatchers.IO,
    foregroundContext = Dispatchers.Main
) {
    override suspend fun executeOnBackground(): List<SongList>? {
        return repository.getSong()
    }
}