package me.tabraiz.learn.kotlin.coroutines.ui.basic

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import me.tabraiz.learn.kotlin.coroutines.R

class BasicActivity : AppCompatActivity() {

    private val myActivityScope = CoroutineScope(Dispatchers.Main.immediate)

    companion object {
        private const val TAG = "BasicActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)
    }

    override fun onDestroy() {
        super.onDestroy()
        myActivityScope.cancel()
    }

    fun testCoroutine(view: View) {
        testCoroutine()
    }

    fun testCoroutineWithMain(view: View) {
        testCoroutineWithMain()
    }

    fun testCoroutineWithMainImmediate(view: View) {
        testCoroutineWithMainImmediate()
    }

    fun testCoroutineEverything(view: View) {
        testCoroutineEverything()
    }

    fun usingGlobalScope(view: View) {
        usingGlobalScope()
    }

    fun globalScopeInsideLifecycleScope(view: View) {
        globalScopeInsideLifecycleScope()
    }

    fun launchInsideLifecycleScope(view: View) {
        launchInsideLifecycleScope()
    }

    fun twoLaunches(view: View) {
        twoLaunches()
    }

    fun twoAsyncInsideLifecycleScope(view: View) {
        twoAsyncInsideLifecycleScope()
    }

    fun twoWithContextInsideLifecycleScope(view: View) {
        twoWithContextInsideLifecycleScope()
    }

    fun usingMyActivityScope(view: View) {
        usingMyActivityScope()
    }

    fun twoTasks(view: View) {
        twoTasks()
    }

    fun parentAndChildTaskCancel(view: View) {
        parentAndChildTaskCancel()
    }

    fun parentAndChildTaskCancelIsActive(view: View) {
        parentAndChildTaskCancelIsActive()
    }

    fun lifecycleScopeWithHandlerException(view: View) {
        lifecycleScopeWithHandlerException()
    }

    fun lifecycleScopeWithHandler(view: View) {
        lifecycleScopeWithHandler()
    }

    fun myActivityScopeWithHandlerException(view: View) {
        myActivityScopeWithHandlerException()
    }

    fun myActivityScopeWithHandler(view: View) {
        myActivityScopeWithHandler()
    }

    fun exceptionInLaunchBlock(view: View) {
        exceptionInLaunchBlock()
    }

    fun exceptionInAsyncBlock(view: View) {
        exceptionInAsyncBlock()
    }

    fun exceptionInAsyncBlockWithAwait(view: View) {
        exceptionInAsyncBlockWithAwait()
    }

    private fun testCoroutine() {
        Log.d(TAG, "Function Start")

        lifecycleScope.launch {
            Log.d(TAG, "Before Task")
            doLongRunningTask()
            Log.d(TAG, "After Task")
        }

        Log.d(TAG, "Function End")
    }

    private fun testCoroutineWithMain() {
        Log.d(TAG, "Function Start")

        lifecycleScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Before Task")
            doLongRunningTask()
            Log.d(TAG, "After Task")
        }

        Log.d(TAG, "Function End")
    }

    // similar to #testCoroutine
    private fun testCoroutineWithMainImmediate() {
        Log.d(TAG, "Function Start")

        lifecycleScope.launch(Dispatchers.Main.immediate) {
            Log.d(TAG, "Before Task")
            doLongRunningTask()
            Log.d(TAG, "After Task")
        }

        Log.d(TAG, "Function End")
    }

    private fun testCoroutineEverything() {
        Log.d(TAG, "Function Start")

        lifecycleScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Before Task 1")
            doLongRunningTask()
            Log.d(TAG, "After Task 1")
        }

        lifecycleScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Before Task 2")
            doLongRunningTask()
            Log.d(TAG, "After Task 2")
        }

        Log.d(TAG, "Function End")
    }

    // NOTE: NEVER USE GlobalScope, I have used it for the educational purpose only.
    private fun usingGlobalScope() {
        Log.d(TAG, "Function Start")
        GlobalScope.launch {
            Log.d(TAG, "Before Task")
            doLongRunningTask()
            Log.d(TAG, "After Task")
        }
        Log.d(TAG, "Function End")
    }

    private fun usingMyActivityScope() {
        Log.d(TAG, "Function Start")
        myActivityScope.launch {
            Log.d(TAG, "Before Task")
            doLongRunningTask()
            Log.d(TAG, "After Task")
        }
        Log.d(TAG, "Function End")
    }

    private suspend fun doLongRunningTask() {
        withContext(Dispatchers.Default) {
            // your code for doing a long running task
            // Added delay to simulate
            Log.d(TAG, "Before Delay")
            delay(2000)
            Log.d(TAG, "After Delay")
        }
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

    private fun globalScopeInsideLifecycleScope() {
        Log.d(TAG, "Function Start")
        lifecycleScope.launch {
            Log.d(TAG, "Before Task")
            GlobalScope.launch(Dispatchers.Default) {
                Log.d(TAG, "Before Delay")
                delay(2000)
                Log.d(TAG, "After Delay")
            }
            Log.d(TAG, "After Task")
        }
        Log.d(TAG, "Function End")
    }

    private fun launchInsideLifecycleScope() {
        Log.d(TAG, "Function Start")
        lifecycleScope.launch {
            Log.d(TAG, "Before Task")
            launch(Dispatchers.Default) {
                Log.d(TAG, "Before Delay")
                delay(2000)
                Log.d(TAG, "After Delay")
            }
            Log.d(TAG, "After Task")
        }
        Log.d(TAG, "Function End")
    }

    private fun twoLaunches() {
        Log.d(TAG, "Function Start")

        lifecycleScope.launch(Dispatchers.Default) {
            Log.d(TAG, "Before Delay 1")
            delay(2000)
            Log.d(TAG, "After Delay 1")
        }

        lifecycleScope.launch(Dispatchers.Default) {
            Log.d(TAG, "Before Delay 2")
            delay(2000)
            Log.d(TAG, "After Delay 2")
        }

        Log.d(TAG, "Function End")
    }

    private fun twoWithContextInsideLifecycleScope() {
        Log.d(TAG, "Function Start")
        lifecycleScope.launch {
            Log.d(TAG, "Before Task 1")
            val resultOne = doLongRunningTaskOne()
            Log.d(TAG, "After Task 1")
            Log.d(TAG, "Before Task 2")
            val resultTwo = doLongRunningTaskTwo()
            Log.d(TAG, "After Task 2")
            val result = resultOne + resultTwo
            Log.d(TAG, "result : $result")
        }
        Log.d(TAG, "Function End")
    }

    private fun twoAsyncInsideLifecycleScope() {
        Log.d(TAG, "Function Start")

        lifecycleScope.launch {
            Log.d(TAG, "Before Task")

            val deferredOne = async {
                doLongRunningTaskOne()
            }

            val deferredTwo = async {
                doLongRunningTaskTwo()
            }

            val result = deferredOne.await() + deferredTwo.await()

            Log.d(TAG, "result : $result")

            Log.d(TAG, "After Task")
        }

        Log.d(TAG, "Function End")
    }

    private fun twoTasks() {
        Log.d(TAG, "Function Start")

        val job = lifecycleScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Before Task 1")
            doLongRunningTask()
            Log.d(TAG, "After Task 1")
        }

        lifecycleScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Before Task 2")
            job.cancel()
            doLongRunningTask()
            Log.d(TAG, "After Task 2")
        }

        Log.d(TAG, "Function End")
    }

    private fun parentAndChildTaskCancel() {
        Log.d(TAG, "Function Start")

        lifecycleScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Before Task")
            childTask(coroutineContext[Job]!!)
            Log.d(TAG, "After Task")
        }

        Log.d(TAG, "Function End")
    }

    private suspend fun childTask(parent: Job) {
        withContext(Dispatchers.Default) {
            Log.d(TAG, "childTask start")
            parent.cancel()
            Log.d(TAG, "childTask parent cancel")
            // your code for doing a long running task
            // Added delay to simulate
            delay(2000)
            Log.d(TAG, "childTask end")
        }
    }

    private fun parentAndChildTaskCancelIsActive() {
        Log.d(TAG, "Function Start")

        lifecycleScope.launch(Dispatchers.Main) {
            Log.d(TAG, "Before Task")
            childTaskWithIsActive(coroutineContext[Job]!!)
            Log.d(TAG, "After Task")
        }

        Log.d(TAG, "Function End")
    }

    private suspend fun childTaskWithIsActive(parent: Job) {
        withContext(Dispatchers.Default) {
            Log.d(TAG, "childTask start")
            parent.cancel()
            if (isActive) {
                Log.d(TAG, "childTask parent cancel")
            }
            // your code for doing a long running task
            // Added delay to simulate
            delay(2000)
            Log.d(TAG, "childTask end")
        }
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, e ->
        Log.d(TAG, "exception handler: $e")
    }

    private fun lifecycleScopeWithHandlerException() {
        Log.d(TAG, "Function Start")
        lifecycleScope.launch(exceptionHandler) {
            Log.d(TAG, "Before Task")
            doLongRunningTask()
            throw Exception("Some Exception")
            Log.d(TAG, "After Task")
        }
        Log.d(TAG, "Function End")
    }

    private fun lifecycleScopeWithHandler() {
        Log.d(TAG, "Function Start")
        lifecycleScope.launch(exceptionHandler) {
            Log.d(TAG, "Before Task")
            doLongRunningTask()
            Log.d(TAG, "After Task")
        }
        Log.d(TAG, "Function End")
    }

    private fun myActivityScopeWithHandlerException() {
        Log.d(TAG, "Function Start")
        myActivityScope.launch(exceptionHandler) {
            Log.d(TAG, "Before Task")
            doLongRunningTask()
            throw Exception("Some Exception")
            Log.d(TAG, "After Task")
        }
        Log.d(TAG, "Function End")
    }

    private fun myActivityScopeWithHandler() {
        Log.d(TAG, "Function Start")
        myActivityScope.launch(exceptionHandler) {
            Log.d(TAG, "Before Task")
            doLongRunningTask()
            Log.d(TAG, "After Task")
        }
        Log.d(TAG, "Function End")
    }

    private fun exceptionInLaunchBlock() {
        lifecycleScope.launch {
            doSomethingAndThrowException()
        }
    }

    private fun exceptionInAsyncBlock() {
        lifecycleScope.async {
            doSomethingAndThrowException()
        }
    }

    private fun exceptionInAsyncBlockWithAwait() {
        lifecycleScope.launch {
            val deferred = lifecycleScope.async(Dispatchers.Default) {
                doSomethingAndThrowException()
                return@async 10
            }
            try {
                val result = deferred.await()
            } catch (e: Exception) {
                Log.d(TAG, "exception handler: $e")
            }
        }
    }

    private fun doSomethingAndThrowException() {
        throw Exception("Some Exception")
    }

    private fun learnLaunch() {
        lifecycleScope.launch(Dispatchers.Default) {
            // do something
        }
    }

    private fun learnLaunchWithJob() {
        val job = lifecycleScope.launch(Dispatchers.Default) {
            // do something
        }
    }

    private suspend fun learnAsync() {
        val deferred = lifecycleScope.async(Dispatchers.Default) {
            // do something
            return@async 10
        }
        val result = deferred.await()
    }

    private suspend fun asyncWithReturn(): Int {
        return lifecycleScope.async(Dispatchers.Default) {
            // do something
            return@async 10
        }.await()
    }

    private suspend fun learnWithContext() {
        val result = withContext(Dispatchers.Default) {
            // do something
            return@withContext 10
        }
    }

    private suspend fun withContextWithReturn(): Int {
        return withContext(Dispatchers.Default) {
            // do something
            return@withContext 10
        }
    }

}