package com.bank.model.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.bank.model.enums.StatusLancamento;
import com.bank.model.enums.TipoLancamento;

@Entity
@Table(name= "lancamento")
public class Lancamento {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "mes")
	private Integer mes;
	
	@Column(name = "ano")
	private Integer ano;
	
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@Column(name = "valor")
	private BigDecimal valor;
	
	@Column(name = "data_cadastro")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dataCadastro;
	
	@Column(name = "tipo")
	@Enumerated(value = EnumType.STRING)
	private TipoLancamento tipo;
	
	@Column(name = "situacao")
	@Enumerated(value = EnumType.STRING)
	private StatusLancamento situacao;
	
	public Lancamento() {
		super();
	}

	public Lancamento(Long id, String descricao, Integer mes, Integer ano, Usuario usuario, BigDecimal valor,
			LocalDate dataCadastro, TipoLancamento tipo, StatusLancamento situacao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.mes = mes;
		this.ano = ano;
		this.usuario = usuario;
		this.valor = valor;
		this.dataCadastro = dataCadastro;
		this.tipo = tipo;
		this.situacao = situacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public TipoLancamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoLancamento tipo) {
		this.tipo = tipo;
	}

	public StatusLancamento getSituacao() {
		return situacao;
	}

	public void setSituacao(StatusLancamento situacao) {
		this.situacao = situacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, dataCadastro, descricao, id, mes, situacao, tipo, usuario, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(dataCadastro, other.dataCadastro)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(mes, other.mes) && situacao == other.situacao && tipo == other.tipo
				&& Objects.equals(usuario, other.usuario) && Objects.equals(valor, other.valor);
	}

	@Override
	public String toString() {
		return "Lancamento [id=" + id + ", descricao=" + descricao + ", mes=" + mes + ", ano=" + ano + ", usuario="
				+ usuario + ", valor=" + valor + ", dataCadastro=" + dataCadastro + ", tipo=" + tipo + ", situacao="
				+ situacao + "]";
	}
	
}
