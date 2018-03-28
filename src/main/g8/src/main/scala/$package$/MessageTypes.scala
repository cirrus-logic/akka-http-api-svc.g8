package $package$

/*
 MessageTypes is meant to be mixed in to any object that
 needs to define akka and/or json messages. The types should
 use the traits to mark the messages by type but keep the
 messages contained in the object's context that is defining
 them.

 The goal of this is to reduce the scope of recompile changes
 when a message object is changed and thus speed up recompilation.
 */
object MessageTypes {

  trait Msg
  trait Cmd extends Msg
  trait Evt extends Msg
  trait Query extends Msg

  trait JsObj

  case class CmdFailed(command: Cmd, exception: Throwable) extends Evt
}
