package com.example.marsphotos.fake

import com.example.marsphotos.rules.TestDispatcherRule
import com.example.marsphotos.ui.screens.MarsUiState
import com.example.marsphotos.ui.screens.MarsViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

// 단위테스트에서는 안드로이드 UI thread를 사용할 수 없다.
// 단위테스트는 안드로이드 기기나 에뮬레이터가 아닌 워크 스테이션에서 실행되기 때문이다.
class MarsViewModelTest {

    @get: Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() =
        runTest {
            val marsViewModel = MarsViewModel(
                marsPhotosRepository = FakeNetworkMarsPhotosRepository(),
            )
            assertEquals(
                MarsUiState.Success("Success: ${FakeDataSource.photosList.size} Mars photos retrieved"),
                marsViewModel.marsUiState,
            )
        }
}
