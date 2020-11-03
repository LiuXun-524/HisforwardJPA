package com.example.demojpa.service;

import java.util.List;

import com.example.demojpa.domain.entity.RespMsg;
import com.example.demojpa.domain.entity.Scheduling;

public interface ISchedulingSer {

	public RespMsg<?> save(List<Scheduling> list);

}
