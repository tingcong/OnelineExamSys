package com.tc.entity;

import java.io.Serializable;

/**
 * Created by TingCong on 2017/5/30.
 */
public class ExamPaper implements Serializable {
    private static final long serialVersionUID = 3142100188006800439L;
    private Integer examId;
    private String examName;
    private Integer singleNum;
    private Integer judgeNum;
    private Integer essayNum;
}
