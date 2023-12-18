//package com.magang.plnicon.entity.mapper.bidan;
//
//
//import com.magang.plnicon.dto.BidanDTO;
//import com.magang.plnicon.entity.Bidan;
//import com.magang.plnicon.entity.mapper.user.UserMapper;
//import lombok.experimental.UtilityClass;
//
///**
// * Utility class for mapping operations related to {@link Bidan} and {@link BidanDTO}.
// */
//@UtilityClass
//public class BidanMapper {
//
//    /**
//     * Converts an {@link Bidan} object to an {@link BidanDTO}.
//     *
//     * @param source The {@link Bidan} object to be converted.
//     * @return An {@link BidanDTO} containing data from the source object.
//     */
//    public static BidanDTO toBidanDTO(Bidan source) {
//        return BidanDTO.builder()
//                .id(source.getId())
//                .user(UserMapper.toDTO(source.getUser()))
//                .bidanRecords(BidanRecordMapper.toDTO(source.getBidanRecords()))
//                .createdAt(source.getCreatedAt())
//                .build();
//    }
//
//}
