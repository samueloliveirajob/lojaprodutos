$(document).ready(function() {
	
	$("#btnGerarLink").click(function(e) {
		e.preventDefault();
		var codBanco = $('#codBanco').val();
		var agencia = $('#agencia').val();
		var matricula = $('#matricula').val();
		var nome = $('#nome').val();

		$.ajax({
			type : 'GET',
			contentType : "application/json",
			url: 'http://localhost:8085/street-api/url/' + codBanco + '/'+ nome + '/' + agencia + '/' + matricula,
			success : function(data) {
				$('#linkGerado').val(data.urlCompra);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				$('#linkGerado').val(">>> ERRO AO OBTER LINK <<<");
			}
		});
		
	});
	
	$("#btnSms").click(function(e) {
		e.preventDefault();
		var codBanco = $('#codBanco').val();
		var celular = $('#celular').val();
		var agencia = $('#agencia').val();
		var matricula = $('#matricula').val();		

		$.ajax({
			type : 'GET',
			contentType : "application/json",
			url: 'http://localhost:8085/street-api/sendSMSCadastro/' + codBanco + '/' + agencia + "/" + matricula + "/" + celular,
			success : function(data) {
				alert('Status: ' + data.retornoSMS);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('ERRO');
			}
		});		
		
	});		
	
	$("#btnEmail").click(function(e) {
		e.preventDefault();
		var email = $('#email').val();
		var nome = $('#nome').val();
		var linkGerado = $('#linkGerado').val();
		
		var arrayId = linkGerado.split("/");
		var identificacao = (arrayId[arrayId.length-1]);

		var emailParams = {
			"identificacao": identificacao,
			"nome": nome,
			"emailList" : email,
			"urlCompra": linkGerado
		};
		
		$.ajax({
			type : 'POST',
			contentType : "application/json",
			url : 'http://localhost:8085/street-api/sendEmailCadastro',
			data : JSON.stringify(emailParams),
			dataType : 'json',
			success : function(data) {
				
				if (data.emailResponse.emailsErro.length == 0){
					alert("E-mail enviado com sucesso");
				} else {
					alert("Erro ao enviar e-mail para: " + data.emailResponse.emailsErro.join());
				}
				
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("Erro ao enviar e-mail");
			}
		});
				
	});
	
});