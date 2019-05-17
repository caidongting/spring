package com.example.spring

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class ApplicationTests {

  @Test
  fun contextLoads() {
  }

//  private var mvc: MockMvc? = null
//
//  @Before
//  @Throws(Exception::class)
//  fun setUp() {
//    mvc = MockMvcBuilders.standaloneSetup(HelloController()).build()
//  }
//
//  @Test
//  @Throws(Exception::class)
//  fun getHello() {
//    mvc!!.perform(MockMvcRequestBuilders.get("/hello")
//       .accept(MediaType.APPLICATION_JSON))
//       .andExpect(MockMvcResultMatchers.status().isOk)
//       .andDo(MockMvcResultHandlers.print())
//       .andReturn()
//  }

}
