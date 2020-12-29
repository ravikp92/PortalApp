package com.ravi.assignment.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public class Auditable<U> {
  @CreatedBy
  @Column(name = "created_by")
  private U createdBy;
  
  @CreatedDate
  @Column(name = "created_date")
  private Date createdDate;
  
  @LastModifiedBy
  @Column(name = "last_modified_by")
  private U lastModifiedBy;
  
  @LastModifiedDate
  @Column(name = "last_modified_date")
  private Date lastModifiedDate;
  
  protected U getCreatedBy() {
    return this.createdBy;
  }
  
  protected void setCreatedBy(U createdBy) {
    this.createdBy = createdBy;
  }
  
  protected Date getCreatedDate() {
    return this.createdDate;
  }
  
  protected void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  
  protected U getLastModifiedBy() {
    return this.lastModifiedBy;
  }
  
  protected void setLastModifiedBy(U lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }
  
  protected Date getLastModifiedDate() {
    return this.lastModifiedDate;
  }
  
  protected void setLastModifiedDate(Date lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }
}
