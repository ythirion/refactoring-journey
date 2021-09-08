package dealing.`with`.generalization

final case class Concert(description: String, volume: Int = 0) extends Event {

  def volumeUp(increase: Int): Concert = copy(volume = volume + increase)

  def volumeDown(decrease: Int): Concert = copy(volume = volume - decrease)
}
