package kr.co.kmarket2.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import kr.co.kmarket2.entity.ProductEntity;
import kr.co.kmarket2.vo.ProductVO;

@Mapper
public interface ProductMapper {
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
    @Mapping(source = "prodNo", target = "prodNo")
    @Mapping(source = "prodCate1", target = "prodCate1")
    @Mapping(source = "prodCate2", target = "prodCate2")
    @Mapping(source = "prodName", target = "prodName")
    @Mapping(source = "descript", target = "descript")
    @Mapping(source = "company", target = "company")
    @Mapping(source = "seller", target = "seller")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "discount", target = "discount")
    @Mapping(source = "point", target = "point")
    @Mapping(source = "stock", target = "stock")
    @Mapping(source = "sold", target = "sold")
    @Mapping(source = "delivery", target = "delivery")
    @Mapping(source = "hit", target = "hit")
    @Mapping(source = "score", target = "score")
    @Mapping(source = "review", target = "review")
    @Mapping(source = "thumb1", target = "thumb1")
    @Mapping(source = "thumb2", target = "thumb2")
    @Mapping(source = "thumb3", target = "thumb3")
    @Mapping(source = "detail", target = "detail")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "duty", target = "duty")
    @Mapping(source = "receipt", target = "receipt")
    @Mapping(source = "bizType", target = "bizType")
    @Mapping(source = "origin", target = "origin")
    @Mapping(source = "ip", target = "ip")
    @Mapping(source = "rdate", target = "rdate")	
    ProductEntity toEntity(ProductVO vo);
	
}
