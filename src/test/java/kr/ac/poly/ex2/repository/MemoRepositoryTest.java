package kr.ac.poly.ex2.repository;

import jakarta.transaction.Transactional;
import kr.ac.poly.ex2.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MemoRepositoryTest {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass(){
        System.out.println(memoRepository.getClass().getName());
    }


    @Test
    public void testSelect(){
        Long mno = 100L;

        Optional<Memo> result = memoRepository.findById(mno);
        System.out.println("=================================");
        if(result.isPresent()){
            Memo memo = result.get();
            System.out.print(memo);
        }
    }
    @Transactional
    @Test
    public void testSelect2(){
        Long mno = 100L;

        Memo memo = memoRepository.getOne(mno);
        System.out.println("=================================");
        System.out.print(memo);
        }

        @Test
    public void testUpdate(){
        Memo memo = Memo.builder().mno(100).memoText("Update Text").build();
        System.out.println(memoRepository.save());
        }

        @Test
    public  void testDelete(){
        Long mno = 100L;
        memoRepository.deleteById(mno);
        }

        @Test
    public void testPageDefault(){
            Pageable pageable = (Pageable) PageRequest.of(0, 10);
            Page<Memo> result = memoRepository.findAll(pageable);
            System.out.println(result);
            System.out.println("=============================");
            System.out.println("전체 페이지 개수" + result.getTotalPages());
            System.out.println("전체 페이지 개수" + result.getTotalElements());
            System.out.println("Page Number In Present: " + result.getNumber());
            System.out.println("Count Per Page" + result.getSize());
            System.out.println("has Next Page" + result.hasNext());
            System.out.println("has First Page" + result.isFirst());
            System.out.println("=============================");
            for (Memo memo : result.getContent())

    @Test
    public void testSort(){
                    Sort sort = Sort.by("mno").descending();
                    Pageable pageable1 = PageRequest.of(0, 10, sort);
                    Page<Memo> result = memoRepository.findAll(pageable);
                    result.get().forEach(memo -> {
                        System.out.println(memo);
                    });
            }
            @Test
                    public void testQueryMethod(){
                        List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(50L,80L);
                        for (Memo memo: list) {
                            System.out.println(memo);
                        }
            }
            @Test
            public void testQueryMethodWithPagable(){
               Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending())
                Page<Memo> result = memoRepository.findByMnoBetween(20L, 50L, pageable);
                result.get().forEach(
                        memo -> System.out.println(memo)
                );

                    System.out.println(memo);
                }

            @Test
            @Commit
            @Transactional
            public void testDeleteQueryMethods(){
                memoRepository.deleteMemoByMnoLessThan(10L);
            }
            @Test
                    public void testGetListDesc(){
                List<Memo> list = memoRepository.getListDesc();
                for (Memo memo: list) {
                    System.out.println(memo);
                }
            }

            @Test
            public void testUpdateMemoText(){
                int updateCount = memoRepository.updateMemoText(30L, "30행 수정됨");
            }

            @Test
            public void testUpdateMemoText2(){
                Memo memo = new Memo();
                memo.setMno(31);
                memo.setMemoText("31행 수정 Memo객체 참조값을 param으로 사용");
                int updateCount = memoRepository.updateMemoText2(memo);
            }

            @Test
            public void testGetListWithQuery(){
                Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
                Page<Memo> result = memoRepository.getListWithQuery(32L, pageable);
                result.get().forEach(
                        memo -> System.out.println(memo)
                );
            }
        }
}
