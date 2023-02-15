package kr.co.kmarket2.mappers;

/*
 * 날짜: 2023/02/15
 * 이름: 김지홍
 * 내용: mapstruct를 이용하여 Entity-dto 변환하기 
 */
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

import kr.co.kmarket2.dto.ProductDTO;
import kr.co.kmarket2.entity.ProductEntity;

@Mapper
public interface ProductMapper {
	
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
//	ProductEntity toEntity(ProductDTO dto);
	
	
//	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
    
//    @Mapping(source = "prodCate1", target = "prodCate1")
//    @Mapping(source = "prodCate2", target = "prodCate2")
//    @Mapping(source = "prodName", target = "prodName")
//    @Mapping(source = "descript", target = "descript")
//    @Mapping(source = "company", target = "company")
//    @Mapping(source = "seller", target = "seller")
//    @Mapping(source = "price", target = "price")
//    @Mapping(source = "discount", target = "discount")
//    @Mapping(source = "point", target = "point")
//    @Mapping(source = "stock", target = "stock")
    
	
//    @Mapping(source = "status", target = "status")
//    @Mapping(source = "duty", target = "duty")
//    @Mapping(source = "receipt", target = "receipt")
//    @Mapping(source = "bizType", target = "bizType")
//    @Mapping(source = "origin", target = "origin")
//    @Mapping(source = "ip", target = "ip")
//    @Mapping(source = "rdate", target = "rdate")
//	@Mapping(target = "prodNo", ignore = true)
//	@Mapping(source = "sold", target = "sold", defaultValue = "0", ignore = true)
//    @Mapping(source = "delivery", target = "delivery", defaultValue = "0", ignore = true)
//    @Mapping(source = "hit", target = "hit", defaultValue = "0", ignore = true)
//    @Mapping(source = "score", target = "score", defaultValue = "0", ignore = true)
//    @Mapping(source = "review", target = "review", defaultValue = "0", ignore = true)
    @Mapping(source = "dto.thumb1", target = "thumb1", qualifiedByName = "title")
    @Mapping(source = "dto.thumb2", target = "thumb2", qualifiedByName = "title")
    @Mapping(source = "dto.thumb3", target = "thumb3", qualifiedByName = "title")
    @Mapping(source = "dto.detail", target = "detail", qualifiedByName = "title")
    ProductEntity toEntity(ProductDTO dto);
	
    @Named("title")
    static String fileToTitle(MultipartFile file) {
		return file.getOriginalFilename();
    	
    }
}
