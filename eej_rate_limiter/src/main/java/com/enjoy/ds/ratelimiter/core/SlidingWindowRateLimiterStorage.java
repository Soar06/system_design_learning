package com.enjoy.ds.ratelimiter.core;

import reactor.core.publisher.Mono;

public interface SlidingWindowRateLimiterStorage {
  public Mono<Boolean> putTimeStamp(String key, Long reqTimeStamp, Long window, Integer limit);
}
