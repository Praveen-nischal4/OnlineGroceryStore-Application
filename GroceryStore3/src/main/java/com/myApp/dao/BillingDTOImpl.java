package com.myApp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.myApp.Dto.BillingDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.Statement;
@Repository
public class BillingDTOImpl implements BillingDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void saveBillDetails(BillingDTO billingDTO) {
		
		String sql ="insert into billing(bill_no,bill_date,order_id,coupon_code,total) values (?,?,?,?,?)";
		  KeyHolder keyHolder = new GeneratedKeyHolder();
		  
		  jdbcTemplate.update(connection -> {
	            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	            ps.setString(1, billingDTO.getBill_no());
	            ps.setString(2, billingDTO.getBill_date());
	            ps.setString(3, billingDTO.getOrder_id());
	            ps.setBoolean(4, billingDTO.isCoupon_code());
	            ps.setDouble(5, billingDTO.getTotal());
	            return ps;
	        }, keyHolder);

	        int generatedId = keyHolder.getKey().intValue();
	        billingDTO.setBill_id(generatedId);
	    }
		
		//jdbcTemplate.update(sql, billingDTO.getBill_no(),billingDTO.getBill_date(),billingDTO.getOrder_id(),billingDTO.isCoupon_code()? 1 : 0,billingDTO.getTotal());
	

	 @Override
	    public BillingDTO getBillDetailsByOrderId(String orderId) {
	        String sql = "SELECT * FROM billing WHERE order_id = ?";
	        return jdbcTemplate.queryForObject(sql, new Object[]{orderId}, new BillingRowMapper());
	    }

	 private static final class BillingRowMapper implements RowMapper<BillingDTO> {
	        @Override
	        public BillingDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
	            BillingDTO billing = new BillingDTO();
	            billing.setBill_id(rs.getInt("bill_id"));
	            billing.setBill_no(rs.getString("bill_no"));
	            billing.setBill_date(rs.getString("bill_date"));
	            billing.setOrder_id(rs.getString("order_id"));
	            billing.setCoupon_code(rs.getBoolean("coupon_code"));
	            billing.setTotal(rs.getDouble("total"));
	            return billing;
	        }
	    }


}


