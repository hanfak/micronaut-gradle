package com.hanfak.entrypoint.rest;

import com.hanfak.core.Usecase;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;
import io.reactivex.Single;

import javax.inject.Inject;

@Controller("/")
@Validated
public class UsecaseController {

  @Inject
  Usecase usecase;

  @Get(uri = "/usecase", produces = MediaType.TEXT_PLAIN)
  public Single<String> usecase() {
    return Single.just(usecase.execute());
  }
}
