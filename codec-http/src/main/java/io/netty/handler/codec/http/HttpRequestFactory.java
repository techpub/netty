package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public interface HttpRequestFactory {

  HttpRequest newHttpRequest(ChannelHandlerContext ctx,
      HttpVersion version, HttpMethod method, String uri);

  FullHttpRequest newFullHttpRequest(ChannelHandlerContext ctx,
      HttpVersion version, HttpMethod method, String uri, ByteBuf content);

  HttpContent newHttpContent(ChannelHandlerContext ctx, ByteBuf content);

  LastHttpContent newLastHttpContent(ChannelHandlerContext ctx, ByteBuf content);

  LastHttpContent newEmptyLastHttpContent(ChannelHandlerContext ctx);
}
