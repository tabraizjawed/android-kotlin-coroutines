package me.tabraiz.learn.kotlin.coroutines.ui.task.twotasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import me.tabraiz.learn.kotlin.coroutines.data.api.ApiHelper
import me.tabraiz.learn.kotlin.coroutines.data.local.DatabaseHelper
import me.tabraiz.learn.kotlin.coroutines.ui.base.UiState

class TwoLongRunningTasksViewModel(
    private val apiHelper: ApiHelper, private val dbHelper: DatabaseHelper
) : ViewModel() {

    private val uiState = MutableLiveData<UiState<String>>()

    fun startLongRunningTask() {
        viewModelScope.launch {
            uiState.postValue(UiState.Loading)
            try {
                // do long running tasks
                val resultOneDeferred = async { doLongRunningTaskOne() }
                val resultTwoDeferred = async { doLongRunningTaskTwo() }
                val combinedResult = resultOneDeferred.await() + resultTwoDeferred.await()

                uiState.postValue(UiState.Success("Task Completed : $combinedResult"))
            } catch (e: Exception) {
                uiState.postValue(UiState.Error("Something Went Wrong"))
            }
        }
    }

    fun getUiState(): LiveData<UiState<String>> {
        return uiState
    }

    private suspend fun doLongRunningTaskOne(): Int {
        return withContext(Dispatchers.Default) {
            // your code for doing a long running task
            // Added delay to simulate
            delay(2000)
            return@withContext 10
        }
    }

    private suspend fun doLongRunningTaskTwo(): Int {
        return withContext(Dispatchers.Default) {
            // your code for doing a long running task
            // Added delay to simulate
            delay(2000)
            return@withContext 10
        }
    }

}