package com.istef.demo3addresslocationdb.json;

import java.util.List;

public record Response(List<Result> results, String status) {
}
