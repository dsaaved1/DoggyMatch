package com.iastate._rk_1.backend.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permission")
public class Permission {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "permission_id")
  private int permissionId;

  @Column(name = "user_id")
  private int userId;

  @Column(name = "code")
  private String code;

  @Column(name = "type")
  private String type;

  @Column(name = "date_granted")
  private Date dateGranted;

  @Column(name = "date_revoked")
  private Date dateRevoked;

  public Permission() {
  }

  public Permission(int userId, String code, String type, Date dateGranted, Date dateRevoked) {
    this.userId = userId;
    this.code = code;
    this.type = type;
    this.dateGranted = dateGranted;
    this.dateRevoked = dateRevoked;
  }

  /**
   *
   * @return
   */
  public int getPermissionId() {
    return permissionId;
  }

  /**
   *
   * @param permissionId
   */
  public void setPermissionId(int permissionId) {
    this.permissionId = permissionId;
  }

  /**
   *
   * @return
   */
  public int getUserId() {
    return userId;
  }

  /**
   *
   * @param userId
   */
  public void setUserId(int userId) {
    this.userId = userId;
  }

  /**
   *
   * @return
   */
  public String getCode() {
    return code;
  }

  /**
   *
   * @param code
   */
  public void setCode(String code) {
    this.code = code;
  }

  /**
   *
   * @return
   */
  public String getType() {
    return type;
  }

  /**
   *
   * @param type
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   *
   * @return
   */
  public Date getDateGranted() {
    return dateGranted;
  }

  /**
   *
   * @param dateGranted
   */
  public void setDateGranted(Date dateGranted) {
    this.dateGranted = dateGranted;
  }

  /**
   *
   * @return
   */
  public Date getDateRevoked() {
    return dateRevoked;
  }

  /**
   *
   * @param dateRevoked
   */
  public void setDateRevoked(Date dateRevoked) {
    this.dateRevoked = dateRevoked;
  }
}