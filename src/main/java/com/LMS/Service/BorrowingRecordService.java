package com.LMS.Service;

import com.LMS.Entites.BorrowingRecord;
import com.LMS.Repositories.BorrowingRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowingRecordService {
    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    public List<BorrowingRecord> getAllBorrowingRecords() {
        return borrowingRecordRepository.findAll();
    }

    public BorrowingRecord getBorrowingRecordById(Integer id) {
        return borrowingRecordRepository.findById(id).orElse(null);
    }

    public BorrowingRecord saveBorrowingRecord(BorrowingRecord borrowingRecord) {
        return borrowingRecordRepository.save(borrowingRecord);
    }

    public void deleteBorrowingRecord(Integer id) {
        borrowingRecordRepository.deleteById(id);
    }
}
