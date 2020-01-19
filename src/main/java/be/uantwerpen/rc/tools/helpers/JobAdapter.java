package be.uantwerpen.rc.tools.helpers;

import be.uantwerpen.rc.models.Job;
import be.uantwerpen.rc.tools.DriveDir;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class JobAdapter implements JsonSerializer<Job>, JsonDeserializer<Job>
{

    @Override
    public JsonElement serialize(Job src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject object = new JsonObject();
        object.addProperty("id", src.getJobId());
        object.addProperty("idStart", src.getIdStart());
        object.addProperty("idEnd", src.getIdEnd());
        if(src.getDriveDirections() != null && !src.getDriveDirections().isEmpty())
        {
            Gson gson = new Gson();
            String driveDirs = gson.toJson(src.getDriveDirections(),new TypeToken<ArrayList<DriveDir>>(){}.getType());
            object.addProperty("driveDir",driveDirs);
        }
        return object;
    }

    @Override
    public Job deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject object = json.getAsJsonObject();
        Gson gson = new Gson();
        Job job = new Job();
        job.setJobId(object.get("id").getAsLong());
        job.setIdStart(object.get("idStart").getAsLong());
        job.setIdEnd(object.get("idEnd").getAsLong());
        if(!object.get("driveDir").isJsonNull())
        {
            ArrayList<DriveDir> driveDirs = gson.fromJson(object.get("driveDir").getAsString(), new TypeToken<ArrayList<DriveDir>>(){}.getType());
            job.setDriveDirections(driveDirs);
        }
        return job;
    }
}
