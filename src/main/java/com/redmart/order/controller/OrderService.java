package com.redmart.order.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.redmart.order.model.Item;

@Path("/order")
public class OrderService {

	@POST
	@Path("placeorder")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_PLAIN })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_PLAIN })
	public Response orderProcessor(@Context UriInfo ui) {
		MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
		Map<String, String> parameters = prepareParameters(queryParams);
		String output = "";
		List<Item> order = new ArrayList<Item>();
		for (Entry<String, String> temp : parameters.entrySet()) {

			Item tempItem = new Item();
			tempItem.setItemName(temp.getKey());
			String[] values = temp.getValue().split(",");
			tempItem.setHeight(Integer.parseInt(values[0]));
			tempItem.setWidth(Integer.parseInt(values[1]));
			tempItem.setBreadth(Integer.parseInt(values[2]));
			order.add(tempItem);
		}

		SlotProcessor ss = new SlotProcessor();

		return Response.status(200).entity(ss.findSlot(order)).build();
	}

	private Map<String, String> prepareParameters(MultivaluedMap<String, String> queryParameters) {

		Map<String, String> parameters = new HashMap<String, String>();

		Iterator<String> it = queryParameters.keySet().iterator();

		while (it.hasNext()) {
			String theKey = (String) it.next();
			parameters.put(theKey, queryParameters.getFirst(theKey));
		}

		return parameters;

	}
}
