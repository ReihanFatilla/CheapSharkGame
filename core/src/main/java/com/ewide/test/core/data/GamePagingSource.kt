//package com.ewide.test.core.data
//
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import androidx.paging.rxjava3.RxPagingSource
//import com.ewide.test.core.data.remote.RemoteDataSource
//import com.ewide.test.core.data.remote.retrofit.ApiService
//import com.ewide.test.core.domain.model.game.Game
//import com.ewide.test.core.mapper.GameMapper.mapToGame
//import io.reactivex.rxjava3.core.Single
//import io.reactivex.rxjava3.schedulers.Schedulers
//
//class GamePagingSource(private val apiService: ApiService) : PagingSource<Int, Game>() {
//
//    private companion object {
//        const val INITIAL_PAGE_INDEX = 1
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Game> {
//        return try {
//            val position = params.key ?: INITIAL_PAGE_INDEX
//            val responseData = apiService.getGames(position).map { it.mapToGame() }
//            LoadResult.Page(
//                data = responseData,
//                prevKey = if (position == INITIAL_PAGE_INDEX) null else position - 1,
//                nextKey = if (responseData.isNullOrEmpty()) null else position + 1
//            )
//        } catch (exception: Exception) {
//            return LoadResult.Error(exception)
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, Game>): Int? {
//        return state.anchorPosition?.let { anchorPosition ->
//            val anchorPage = state.closestPageToPosition(anchorPosition)
//            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
//        }
//    }
//}