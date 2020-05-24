package com.cantarino.ifood.cadastro;

import java.util.HashMap;
import java.util.Map;

import org.testcontainers.containers.PostgreSQLContainer;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class CadastroTestLifecycleManager implements QuarkusTestResourceLifecycleManager {


    public static final PostgreSQLContainer<?> POSTGRES = new PostgreSQLContainer<>("postgres:12.2");

	@Override
	public Map<String, String> start() {

        POSTGRES.start();

        Map<String, String> props = new HashMap<String, String>();

        props.put("quarkus.datasource.url", POSTGRES.getJdbcUrl());
        props.put("quarkus.datasource.username", POSTGRES.getUsername());
        props.put("quarkus.datasource.password", POSTGRES.getPassword());


		return props;
	}

	@Override
	public void stop() {

        if(POSTGRES != null && POSTGRES.isRunning())
           POSTGRES.stop();
	}

}