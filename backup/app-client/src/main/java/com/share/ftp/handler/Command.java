package com.share.ftp.handler;

public interface Command {

  void execute(CommandRequest request) throws Exception;
}
