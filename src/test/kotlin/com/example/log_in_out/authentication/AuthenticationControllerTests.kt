//package com.example.log_in_out.authentication
//
//import com.example.log_in_out.authentication.services.AuthenticationService
//import org.junit.jupiter.api.Test
//import org.mockito.Mockito.`when`
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.boot.test.mock.mockito.MockBean
//import org.springframework.http.MediaType
//import org.springframework.test.web.servlet.MockMvc
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
//import kotlin.Exception as Exception1
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class AuthenticationControllerTests {
//    @Autowired
//    lateinit var mvc: MockMvc
//
//    @MockBean
//    lateinit var authenticationService: AuthenticationService
//
//    @Test
//    fun `should return a valid token for user abc with password 123`() {
//        `when`(authenticationService.signInWithUsernameAndPassword("abc", "123"))
//                .thenReturn("qwerty")
//        // `when`(authenticationService.signInWithUsernameAndPassword("abc", "456")).thenThrow()
//
//        mvc.perform(post("/api/v1/auth/login")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("""
//                    {
//                        "username": "abc",
//                        "password": "123"
//                    }
//                """.trimIndent()))
//                .andExpect(status().isOk)
//                .andExpect(content().string("qwerty"))
//    }
//
//    @Test
//    fun `should return error message`() {
//        //mock database data
////        `when`(authenticationService.signInWithUsernameAndPassword("abc", "456"))
////                .thenReturn("wrong password")
//        `when`(authenticationService.signInWithUsernameAndPassword("abcd", "123"))
//                .thenReturn("qwert").thenThrow();
//
//        mvc.perform(post("/api/v1/auth/login")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("""
//                    {
//                        "username": "abc",
//                        "password": "123"
//                    }
//                """.trimIndent()))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().isBadRequest)
//                .andExpect(content().string("wrong password"))
//    }
//
//
//    @Test
//    fun `should return logout successful message`() {
//        `when`(authenticationService.signOutWithToken("qwerty"))
//                .thenReturn("Logout Successfully")
//
//        mvc.perform(post("/api/v1/auth/logout")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("""
//                    {
//                        "authenticationToken": "qwerty"
//                    }
//                """.trimIndent()))
//                .andExpect(status().isOk)
//                .andExpect(content().string("Logout Successfully"))
//
//    }
//}
