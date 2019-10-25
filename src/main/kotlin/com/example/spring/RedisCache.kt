package com.example.spring

import org.apache.ibatis.cache.Cache
import java.util.concurrent.locks.ReadWriteLock
import java.util.concurrent.locks.ReentrantReadWriteLock

class RedisCache : Cache {

  private val readWriteLock: ReadWriteLock = ReentrantReadWriteLock()

  override fun clear() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getId(): String {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun removeObject(key: Any?): Any {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getObject(key: Any?): Any {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getSize(): Int {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun putObject(key: Any?, value: Any?) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getReadWriteLock(): ReadWriteLock {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}