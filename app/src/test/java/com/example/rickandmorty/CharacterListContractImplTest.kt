
package com.roquebuarque.cpynpasta

import com.example.rickandmorty.Character
import com.example.rickandmorty.CharacterResult
import com.example.rickandmorty.model.CharacterService
import com.example.rickandmorty.presenter.CharacterListContract
import com.example.rickandmorty.presenter.CharacterListContractImpl
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class RecipeListPresenterImplTest {

    @get:Rule
    var mainCoroutineRule = CoroutineTestRule()

    //set mocks
    private val service: CharacterService = mock()
    private val view: CharacterListContract.View = mock()

    //inicializa a classe que quero testar
    private val testee = CharacterListContractImpl.create(service)

    @Before
    fun setup(){
        testee.attachView(view)
    }

    @After
    fun done(){
        testee.detachView()
    }

    @Test
    fun `test get random recipes success`() {
        runBlockingTest {
            //Given
            val list = getRecipeList()
            whenever(service.getCharacters()).thenReturn(CharacterResult(list))

            //When
            testee.fetchCharacters()

            //Then
            verify(view).displayLoading(true)
            verify(view).displayCharacters(list)
            verify(view).displayLoading(false)

        }
    }

    @Test
    fun `test get random recipes error`() {
        runBlockingTest {
            //Given
            val error = RuntimeException()
            whenever(service.getCharacters()).thenThrow(error)

            //When
            testee.fetchCharacters()

            //Then
            verify(view).displayLoading(true)
            verify(view).showError("Erroww")
            verify(view).displayLoading(false)

        }
    }

    private fun getRecipeList(): List<Character> {
        return listOf(
            Character(
                1,
                "image",
                "source",
                "human"
            )
        )
    }

}