package com.example.marsphotos.fake

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class NetworkMarsRepositoryTest {

    @Test
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() =
        runTest {
            val repository = com.example.marsphotos.data.NetworkMarsPhotosRepository(
                marsApiService = FakeMarsApiService(),
            )
            assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())
        }
}
