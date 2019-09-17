package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Gu Yaming
 * @Description:
 * @Date:Create：in 2019/9/15 14:20
 * @Modified By：
 */
@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll(){
        return labelDao.findAll();
    }

    public Label findById(String id){
        return labelDao.findById(id).get(); //Optional<T> 容器对象，findById(id)返回的，可以通过get得到对象
    }

    public void save(Label label){
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    public void update(Label label){
        labelDao.save(label);
    }

    public void deleteById(String id){
        labelDao.deleteById(id);
    }

    public List<Label> findSearch(Label label) {
        return labelDao.findAll(new Specification<Label>() {
            /**
             *
             * @param root 根对象，封装条件
             * @param query 封装的都是查询关键字 基本不用
             * @param criteriaBuilder 封装条件对象 如果直接返回null表示不需要任何条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //new 一个list来存放条件
                List<Predicate> list = new ArrayList<>();
                if(label.getLabelname() != null && !"".equals(label.getLabelname())){
                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%"); //生产sql 相当于where labelname like %Qq%
                    list.add(predicate);
                }
                if(label.getState() != null && !"".equals(label.getState())){
                    Predicate predicate = criteriaBuilder.equal(root.get("state").as(String.class),label.getState()); //生产sql 相当于where labelname like %Qq%
                    list.add(predicate);
                }
                Predicate[] parr = new Predicate[list.size()];
                parr = list.toArray(parr);
                return criteriaBuilder.and(parr);
            }
        });   //分页 查询条件Specification

    }

    public Page<Label> PageQuery(int page, int size, Label label) {
        Pageable pageable = PageRequest.of(page - 1, size); //页面的页数都是从1开始
        return labelDao.findAll(new Specification<Label>() {
            /**
             *
             * @param root 根对象，封装条件
             * @param query 封装的都是查询关键字 基本不用
             * @param criteriaBuilder 封装条件对象 如果直接返回null表示不需要任何条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //new 一个list来存放条件
                List<Predicate> list = new ArrayList<>();
                if(label.getLabelname() != null && !"".equals(label.getLabelname())){
                    Predicate predicate = criteriaBuilder.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%"); //生产sql 相当于where labelname like %Qq%
                    list.add(predicate);
                }
                if(label.getState() != null && !"".equals(label.getState())){
                    Predicate predicate = criteriaBuilder.equal(root.get("state").as(String.class),label.getState()); //生产sql 相当于where labelname like %Qq%
                    list.add(predicate);
                }
                Predicate[] parr = new Predicate[list.size()];
                parr = list.toArray(parr);
                return criteriaBuilder.and(parr);
            }
        }, pageable);
    }
}
