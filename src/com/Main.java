package com;

import java.io.File;
import java.net.URL;
import java.util.List;

import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

import es.contrataciondelestado.b2b.gestionlicitacionplacsp.ServiciosGestionLicitacionPLACSP;
import es.contrataciondelestado.b2b.gestionlicitacionplacsp.ServiciosGestionLicitacionPLACSPPortType;

public class Main {

	public static void main(String[] args) throws Exception {

		URL url = new File("https://publicacion.preprod-contrataciondelestado.es/ServiciosGestionLicitacionPLACSP?wsdl")
				.toURI().toURL();

		ServiciosGestionLicitacionPLACSP servicio = new ServiciosGestionLicitacionPLACSP(url);
		ServiciosGestionLicitacionPLACSPPortType tipo = servicio.getServiciosGestionLicitacionPLACSPPort();

		tipo.setContractFolder(null, null, null, null, null, null, null, null, null, null, null, null, null);

		Binding binding = ((BindingProvider) tipo).getBinding();

		List<Handler> handlerList = binding.getHandlerChain();
		FirmarServicioHandler handler = new FirmarServicioHandler();
		handlerList.add(handler);
		binding.setHandlerChain(handlerList);

	}

}