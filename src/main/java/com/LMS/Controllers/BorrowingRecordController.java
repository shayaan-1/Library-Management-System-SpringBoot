package com.LMS.Controllers;

import com.LMS.Entites.BorrowingRecord;
import com.LMS.Service.BorrowingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowingRecords")
public class BorrowingRecordController {

    @Autowired
    private BorrowingRecordService borrowingRecordService;

    @GetMapping
    public List<BorrowingRecord> getAllBorrowingRecords() {
        return borrowingRecordService.getAllBorrowingRecords();
    }

    @GetMapping("/{id}")
    public BorrowingRecord getBorrowingRecordById(@PathVariable Integer id) {
        return borrowingRecordService.getBorrowingRecordById(id);
    }

    @PostMapping
    public BorrowingRecord createBorrowingRecord(@RequestBody BorrowingRecord borrowingRecord) {
        return borrowingRecordService.saveBorrowingRecord(borrowingRecord);
    }

    @PutMapping("/{id}")
    public BorrowingRecord updateBorrowingRecord(@PathVariable Integer id, @RequestBody BorrowingRecord borrowingRecord) {
        borrowingRecord.setId(id);
        return borrowingRecordService.saveBorrowingRecord(borrowingRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteBorrowingRecord(@PathVariable Integer id) {
        borrowingRecordService.deleteBorrowingRecord(id);
    }
}
