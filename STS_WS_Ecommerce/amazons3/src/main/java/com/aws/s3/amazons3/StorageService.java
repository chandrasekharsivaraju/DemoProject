package com.aws.s3.amazons3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;

@Service
public class StorageService {
	
	@Autowired
	private AmazonS3 amazonS3;
	
	public void createBucket()
	{
		amazonS3.createBucket("abhista");
		amazonS3.createBucket("abhista1");
		amazonS3.deleteBucket("abhista1");
		List<Bucket> buckets = amazonS3.listBuckets();
		
		for(Bucket bucket:buckets){
			System.out.println("Bucket name :: "+bucket.getName());
		}
		
		String file_path = "C://chandra/resume.txt";
		
		//amazonS3.putObject(bucketName,fileName,file);
		amazonS3.putObject("abhista", "myresumefile.txt", new File(file_path));
		
		S3Object object = amazonS3.getObject("abhista", "myresumefile.txt");
		
		InputStream is = object.getObjectContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		try {
			while ((line = br.readLine()) != null) {
				System.out.println("File Content is :: " + line);
			}
		} catch (IOException e) {}
	}
}
