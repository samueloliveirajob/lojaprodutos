package integration;

import integration.shared.IntegrationServer;

public class VendaEndpointIT extends IntegrationServer {

//    @Test
//    public void should_return_one_pedido() {
//        given()
//                .header("STELO_ID", "700459")
//                .get("http://127.0.0.1:" + jettyPort + "/street-api/orders?quantity=1")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK)
//                .and()
//                .body("data", hasSize(1))
//                .body("amount", equalTo(9));
//    }
//
//    @Test
//    public void should_return_two_pedidos() {
//        given()
//                .header("STELO_ID", "700459")
//                .get("http://127.0.0.1:" + jettyPort + "/street-api/orders?quantity=2")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK)
//                .and()
//                .body("data", hasSize(2))
//                .body("amount", equalTo(9));
//    }
//
//    @Test
//    public void should_return_first_page() {
//        VendasDTO vendasDTO = given()
//                .header("STELO_ID", "500266")
//                .get("http://127.0.0.1:" + jettyPort + "/street-api/orders")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK)
//                .body("data", hasSize(10))
//                .body("amount", equalTo(100))
//                .extract().body().as(VendasDTO.class);
//
//        List<VendaDTO> collect = new ArrayList<>(vendasDTO.getData());
//        collect.sort(Comparator.comparingLong(VendaDTO::getCodigoPedidoStelo).reversed());
//        Assert.assertEquals(collect, vendasDTO.getData());
//    }
//
//    @Test
//    public void should_return_second_page() {
//        VendasDTO vendasDTO = given()
//                .header("STELO_ID", "500266")
//                .get("http://127.0.0.1:" + jettyPort + "/street-api/orders?next=144767750331457")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK)
//                .body("data", hasSize(10))
//                .body("amount", equalTo(100))
//                .extract().body().as(VendasDTO.class);
//        List<VendaDTO> collect = new ArrayList<>(vendasDTO.getData());
//        collect.sort(Comparator.comparingLong(VendaDTO::getCodigoPedidoStelo).reversed());
//        Assert.assertEquals(collect, vendasDTO.getData());
//    }
//
//    @Test
//    public void should_back_to_first_page() {
//        VendasDTO vendasDTO = given()
//                .header("STELO_ID", "500266")
//                .get("http://127.0.0.1:" + jettyPort + "/street-api/orders?previous=144767744380986")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK)
//                .body("data", hasSize(10))
//                .body("amount", equalTo(100))
//                .extract().body().as(VendasDTO.class);
//        List<VendaDTO> collect = new ArrayList<>(vendasDTO.getData());
//        collect.sort(Comparator.comparingLong(VendaDTO::getCodigoPedidoStelo).reversed());
//        Assert.assertEquals(collect, vendasDTO.getData());
//    }
//
//    @Test
//    public void should_back_to_third_page() {
//        VendasDTO vendasDTO = given()
//                .header("STELO_ID", "500266")
//                .get("http://127.0.0.1:" + jettyPort + "/street-api/orders?previous=144751868365638")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK)
//                .body("data", hasSize(10))
//                .body("amount", equalTo(100))
//                .extract().body().as(VendasDTO.class);
//        List<VendaDTO> collect = new ArrayList<>(vendasDTO.getData());
//        collect.sort(Comparator.comparingLong(VendaDTO::getCodigoPedidoStelo).reversed());
//        Assert.assertEquals(collect, vendasDTO.getData());
//    }
//
//    @Test
//    public void should_return_last_page() {
//        VendasDTO vendasDTO = given()
//                .header("STELO_ID", "500266")
//                .get("http://127.0.0.1:" + jettyPort + "/street-api/orders?last=true")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK)
//                .body("data", hasSize(10))
//                .body("amount", equalTo(100))
//                .extract().body().as(VendasDTO.class);
//        List<VendaDTO> collect = new ArrayList<>(vendasDTO.getData());
//        collect.sort(Comparator.comparingLong(VendaDTO::getCodigoPedidoStelo).reversed());
//        Assert.assertEquals(collect, vendasDTO.getData());
//    }
//
//    @Test
//    public void should_return_last_page_with_quantity() {
//        VendasDTO vendasDTO = given()
//                .header("STELO_ID", "500266")
//                .get("http://127.0.0.1:" + jettyPort + "/street-api/orders?last=true&quantity=3")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_OK)
//                .body("data", hasSize(1))
//                .body("amount", equalTo(100))
//                .extract().body().as(VendasDTO.class);
//        List<VendaDTO> collect = new ArrayList<>(vendasDTO.getData());
//        collect.sort(Comparator.comparingLong(VendaDTO::getCodigoPedidoStelo).reversed());
//        Assert.assertEquals(collect, vendasDTO.getData());
//    }
//
//    @Test
//    public void should_return_invalid_quanity() {
//        given()
//                .header("STELO_ID", "700459")
//                .get("http://127.0.0.1:" + jettyPort + "/street-api/orders?quantity=a")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_BAD_REQUEST)
//                .and()
//                .body("field", hasItem("quantity"));
//
//        given()
//                .header("STELO_ID", "700459")
//                .get("http://127.0.0.1:" + jettyPort + "/street-api/orders?quantity=-1")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_BAD_REQUEST)
//                .and()
//                .body("field", hasItem("quantity"));
//
//        given()
//                .header("STELO_ID", "700459")
//                .get("http://127.0.0.1:" + jettyPort + "/street-api/orders?quantity=1001")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_BAD_REQUEST)
//                .and()
//                .body("field", hasItem("quantity"));
//    }
//
//    @Test
//    public void should_return_invalid_next() {
//        given()
//                .header("STELO_ID", "700459")
//                .get("http://127.0.0.1:" + jettyPort + "/street-api/orders?next=a")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_BAD_REQUEST)
//                .and()
//                .body("field", hasItem("next"));
//    }
//
//    @Test
//    public void should_return_invalid_previous() {
//        given()
//                .header("STELO_ID", "700459")
//                .get("http://127.0.0.1:" + jettyPort + "/street-api/orders?previous=a")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_BAD_REQUEST)
//                .and()
//                .body("field", hasItem("previous"));
//    }
//
//    @Test
//    public void should_return_invalid_customerDoc() {
//        given()
//                .header("STELO_ID", "700459")
//                .get("http://127.0.0.1:" + jettyPort + "/street-api/orders?customerDoc=a")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.SC_BAD_REQUEST)
//                .and()
//                .body("field", hasItem("customerDoc"));
//    }

}
