package com.hrfmmr.sdk.common.domain

import com.hrfmmr.sdk.common.data.entity.SampleEntity
import org.junit.Test

class SampleModelTest {
    @Test fun modelChanged_emits_default_value() {
        // Given
        val model = SampleModel()
        val testSubscriber = model.outputs.modelChanged.test()

        // Then
        testSubscriber.assertValue(SampleEntity(name = "alpha"))
    }

    @Test fun modelChanged_emits_change_when_doSomething_is_invoked() {
        // Given
        val model = SampleModel()
        val testSubscriber = model.outputs.modelChanged.test()

        // When
        model.inputs.doSomething()

        // Then
        testSubscriber.assertValues(
                SampleEntity(name = "alpha"),
                SampleEntity(name = "bravo"))
    }
}