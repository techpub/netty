package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class DefaultHttpRequestFactory implements HttpRequestFactory {

  private final boolean validateHeaders;

  public DefaultHttpRequestFactory() {
    this(true);
  }

  public DefaultHttpRequestFactory(boolean validateHeaders) {
    this.validateHeaders = validateHeaders;
  }

  @Override
  public HttpRequest newHttpRequest(ChannelHandlerContext ctx,
      HttpVersion version, HttpMethod method, String uri) {

    return new DefaultHttpRequest(version, method, uri, validateHeaders);
  }

  @Override
  public FullHttpRequest newFullHttpRequest(ChannelHandlerContext ctx,
      HttpVersion version, HttpMethod method, String uri, ByteBuf content) {

    return new DefaultFullHttpRequest(version, method, uri, content);
  }

  @Override
  public HttpContent newHttpContent(ChannelHandlerContext ctx, ByteBuf content) {
    return new DefaultHttpContent(content);
  }

  @Override
  public LastHttpContent newLastHttpContent(ChannelHandlerContext ctx, ByteBuf content) {
    return new DefaultLastHttpContent(content, validateHeaders);
  }

  @Override
  public LastHttpContent newEmptyLastHttpContent(ChannelHandlerContext ctx) {
    return LastHttpContent.EMPTY_LAST_CONTENT;
  }
}
