package me.tabraiz.learn.kotlin.coroutines.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.tabraiz.learn.kotlin.coroutines.data.api.ApiHelper
import me.tabraiz.learn.kotlin.coroutines.data.local.DatabaseHelper
import me.tabraiz.learn.kotlin.coroutines.ui.errorhandling.exceptionhandler.ExceptionHandlerViewModel
import me.tabraiz.learn.kotlin.coroutines.ui.errorhandling.supervisor.IgnoreErrorAndContinueViewModel
import me.tabraiz.learn.kotlin.coroutines.ui.errorhandling.trycatch.TryCatchViewModel
import me.tabraiz.learn.kotlin.coroutines.ui.retrofit.parallel.ParallelNetworkCallsViewModel
import me.tabraiz.learn.kotlin.coroutines.ui.retrofit.series.SeriesNetworkCallsViewModel
import me.tabraiz.learn.kotlin.coroutines.ui.retrofit.single.SingleNetworkCallViewModel
import me.tabraiz.learn.kotlin.coroutines.ui.room.RoomDBViewModel
import me.tabraiz.learn.kotlin.coroutines.ui.task.onetask.LongRunningTaskViewModel
import me.tabraiz.learn.kotlin.coroutines.ui.task.twotasks.TwoLongRunningTasksViewModel
import me.tabraiz.learn.kotlin.coroutines.ui.timeout.TimeoutViewModel

class ViewModelFactory(private val apiHelper: ApiHelper, private val dbHelper: DatabaseHelper) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SingleNetworkCallViewModel::class.java)) {
            return SingleNetworkCallViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(SeriesNetworkCallsViewModel::class.java)) {
            return SeriesNetworkCallsViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(ParallelNetworkCallsViewModel::class.java)) {
            return ParallelNetworkCallsViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(RoomDBViewModel::class.java)) {
            return RoomDBViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(TimeoutViewModel::class.java)) {
            return TimeoutViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(TryCatchViewModel::class.java)) {
            return TryCatchViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(ExceptionHandlerViewModel::class.java)) {
            return ExceptionHandlerViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(LongRunningTaskViewModel::class.java)) {
            return LongRunningTaskViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(TwoLongRunningTasksViewModel::class.java)) {
            return TwoLongRunningTasksViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(IgnoreErrorAndContinueViewModel::class.java)) {
            return IgnoreErrorAndContinueViewModel(apiHelper, dbHelper) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}