package com.madgag.sample.gslrw

trait Emphasiser {
  def emphasise(s: String): String
}

object Emphasiser {
  val Sardonic = new Emphasiser {
    override def emphasise(s: String): String = s"_${s}_"
  }
}