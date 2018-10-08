package com.hrfmmr.sdk.common.domain

import com.hrfmmr.sdk.common.data.entity.SampleEntity
import io.reactivex.Flowable
import io.reactivex.processors.BehaviorProcessor


interface SampleModelInputs {
    fun doSomething()
}


interface SampleModelOutputs {
    val modelChanged: Flowable<SampleEntity>
}


interface SampleModelProtocol {
    val inputs: SampleModelInputs
    val outputs: SampleModelOutputs
}


class SampleModel : SampleModelProtocol, SampleModelInputs, SampleModelOutputs {
    override val inputs: SampleModelInputs
        get() = this
    override val outputs: SampleModelOutputs
        get() = this


    //region Outputs


    override lateinit var modelChanged: Flowable<SampleEntity>
    private val modelChangedProcessor = BehaviorProcessor.createDefault(SampleEntity(name = "alpha"))

    init {
        modelChanged = modelChangedProcessor
    }
    //endregion


    //region Inputss


    override fun doSomething() {
        modelChangedProcessor.onNext(SampleEntity(name = "bravo"))
    }
    //endregion
}
