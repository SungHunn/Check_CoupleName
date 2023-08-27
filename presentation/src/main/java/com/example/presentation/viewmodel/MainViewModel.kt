package com.example.presentation.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.DomainLoveResponse
import com.example.domain.model.DomainScore
import com.example.domain.usecase.CheckLoveCalculatorUseCase
import com.example.domain.usecase.GetScoreUseCase
import com.example.domain.usecase.GetStatisticsUseCase
import com.example.domain.usecase.SetScoreUseCase
import com.example.domain.usecase.SetStatisticsUseCase
import com.example.domain.utils.ErrorType
import com.example.domain.utils.RemoteErrorEmitter
import com.example.domain.utils.ScreenState
import com.example.presentation.widget.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val checkLoveCalculatorUseCase: CheckLoveCalculatorUseCase,
    private val getStatisticsUseCase: GetStatisticsUseCase,
    private val setStatisticsUseCase: SetStatisticsUseCase,
    private val getScoreUseCase: GetScoreUseCase,
    private val setScoreUseCase: SetScoreUseCase
): ViewModel(), RemoteErrorEmitter {

    val apiCallEvent : LiveData<ScreenState>
        get() = _apiCallEvent

    private var _apiCallEvent = SingleLiveEvent<ScreenState>()

    val getStatisticsEvent : LiveData<Int>
        get() = _getStatisticsEvent

    private var _getStatisticsEvent = SingleLiveEvent<Int>()

    val getScoreEvent : LiveData<Int>
        get() = _getScoreEvent

    private var _getScoreEvent = SingleLiveEvent<Int>()

    var apiCallResult = DomainLoveResponse("" , "" ,0 , "")
    var apiErrorType = ErrorType.UNKNOWN
    var apiErrorMessage = "none"

    var manNameResult = "man"
    var womanNameResult = "woman"
    val scoreList = arrayListOf<DomainScore>()
    fun checkLoveCalculator(
        host : String,
        key : String,
        mName : String,
        wName : String
    ) = viewModelScope.launch {
        checkLoveCalculatorUseCase.execute(this@MainViewModel, host, key , mName, wName).let {
            response ->
            //정상호출 경우
            if (response != null){
                apiCallResult = response
                _apiCallEvent.postValue(ScreenState.LOADING)

            }
            // 호출 실패
            else{
                _apiCallEvent.postValue(ScreenState.ERROR)
            }
        }
    }

    fun setStatistics(plusValue : Int) = setStatisticsUseCase.execute(plusValue)

    fun getStatistics() = getStatisticsUseCase.execute()

    fun getStatisticsDisplay() = getStatistics()
        .addOnSuccessListener {
            _getStatisticsEvent.postValue(it.value.toString().toInt())
        }

    fun getScore() = getScoreUseCase.execute()
        .addOnSuccessListener { snapshot ->
            scoreList.clear()
            for(item in snapshot.documents){
                item.toObject(DomainScore::class.java).let {
                    scoreList.add(it!!)
                }
            }
            _getScoreEvent.call()

        }

    fun setScore(man : String, woman : String , percentage : Int, date : String){
        setScoreUseCase.execute(DomainScore(man, woman , percentage ,date))
    }


    override fun onError(msg: String) {
        apiErrorMessage = msg
    }

    override fun onError(errorType: ErrorType) {
        apiErrorType = errorType
    }


}